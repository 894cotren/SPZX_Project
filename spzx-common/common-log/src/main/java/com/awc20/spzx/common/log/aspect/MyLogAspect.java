package com.awc20.spzx.common.log.aspect;


import com.alibaba.fastjson.JSON;
import com.awc20.spzx.common.log.annotation.MyLog;
import com.awc20.spzx.common.log.enums.OperatorType;
import com.awc20.spzx.common.log.service.SysOperLogService;
import com.awc20.spzx.model.entity.order.SysOperLog;
import com.awc20.spzx.model.entity.system.SysUser;
import com.awc20.spzx.model.vo.system.SysUserThreadLocalAuthContextUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.SneakyThrows;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
public class MyLogAspect {

    //这里有个问题是，Mapper写在Manager下的在Manager里实例化的，虽然编译后会自动装配，
    // 但目前我们连编译都通过不了没有这个类啊。
    /*@Autowired
    SysOperLogMapper sysOperLogMapper;*/

    /*
    * 然后解决方案是，manager那边写service接口和实现类。然后因为manager引入了我们当前模块，所以可以把接口拿过来
    * 我们这边放接口，那边放实现类。   这里的重点是Manage引入了我们的，它可以拿到我们这里的接口，然后实现类
    * 实现接口。  然后我们这里也能使用接口来注入实现类。
    * */



    @Autowired
    SysOperLogService sysOperLogService;


    @SneakyThrows
    @Around("@annotation(sysLog)")
    //joinPoint必须作为第一参数
    public Object a( ProceedingJoinPoint joinPoint,MyLog sysLog){
        //获取所需参数，装填日志类
        SysOperLog sysOperLog = new SysOperLog();

        //方法执行前日志封装
        beforeLog(sysOperLog,sysLog,joinPoint);

        // 执行被代理方法
        Object proceed = null;
        try {
            proceed = joinPoint.proceed();
        }catch (Exception e){
            //如果有异常，记录异常时的日志
            afterLog(sysOperLog,sysLog,proceed,1,e.getMessage());
            // 保存日志
            sysOperLogService.saveSysOperLog(sysOperLog);
            throw new Exception(e);
            // return null;
        }

        //方法执行后日志封装
        afterLog(sysOperLog,sysLog,proceed,0,null);

        //日志写入数据库
        sysOperLogService.saveSysOperLog(sysOperLog);
        return proceed;
    }


    private void beforeLog(SysOperLog sysOperLog, MyLog sysLog, ProceedingJoinPoint joinPoint) {

        // 注解信息
        int i = sysLog.businessType();// 业务类型
        String title = sysLog.title();// 模块名
        OperatorType operatorType = sysLog.operatorType();
        sysOperLog.setBusinessType(i);
        sysOperLog.setTitle(title);
        sysOperLog.setOperatorType(operatorType.name());

        // http信息
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        String requestURI = request.getRequestURI();
        String method = request.getMethod();
        String ip = request.getRemoteAddr();
        StringBuffer requestURL = request.getRequestURL();
        String queryString = request.getQueryString();
        sysOperLog.setOperUrl(requestURL.toString());
        sysOperLog.setOperParam(queryString);
        sysOperLog.setRequestMethod(method);
        sysOperLog.setOperIp(ip);

        // 方法本身
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String name = methodSignature.getName();
        sysOperLog.setMethod(name);
        SysUser sysUser = SysUserThreadLocalAuthContextUtil.get();
        sysOperLog.setOperName(sysUser.getUsername());


    }

    private void afterLog(SysOperLog sysOperLog, MyLog sysLog, Object proceed,Integer status,String message) {
        sysOperLog.setStatus(status);
        if(status==0){
            if(proceed!=null){
                sysOperLog.setJsonResult(JSON.toJSONString(proceed));
            }
        }else {
            sysOperLog.setErrorMsg(message);
        }
    }
}
