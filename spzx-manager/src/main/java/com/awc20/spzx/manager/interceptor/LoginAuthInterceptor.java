package com.awc20.spzx.manager.interceptor;

import com.alibaba.fastjson.JSON;
import com.awc20.spzx.model.entity.system.SysUser;
import com.awc20.spzx.model.vo.system.SysUserThreadLocalAuthContextUtil;
import com.awc20.spzx.util.MyAssert;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
@Component
//这是一个拦截器类，作用是拦截需要用户信息的路径，根据前端传入的token查询到用户信息存入本地线程内。
public class LoginAuthInterceptor implements HandlerInterceptor {

    @Autowired
    RedisTemplate<String,String> redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //排除OPTIONS访问（这是个预检跨域请求方式？在正式请求之前发来的轻量级请求）  //但是我现在好像可以不用写也没事儿。
        String method = request.getMethod();
        if (method.equals("OPTIONS")){
            return true;
        }

        //获取前端传入token
        String token = request.getHeader("token");
        MyAssert.notNull(token,"用户拦截器token为空");
        //根据token获得用户信息
        String sysUserJson = redisTemplate.opsForValue().get("user:login:"+token);
        MyAssert.notNull(sysUserJson,"用户拦截器sysUserJson为空");
        SysUser sysUser = JSON.parseObject(sysUserJson, SysUser.class);
        //存入本地线程
        SysUserThreadLocalAuthContextUtil.set(sysUser);
        return true;
    }
}
