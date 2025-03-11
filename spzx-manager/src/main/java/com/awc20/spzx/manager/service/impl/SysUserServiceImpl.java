package com.awc20.spzx.manager.service.impl;

import cn.hutool.Hutool;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.awc20.spzx.manager.mapper.SysUserMapper;
import com.awc20.spzx.manager.service.SysUserService;
import com.awc20.spzx.model.dto.system.LoginDto;
import com.awc20.spzx.model.dto.system.SysUserDto;
import com.awc20.spzx.model.entity.system.SysUser;
import com.awc20.spzx.model.vo.system.LoginVo;
import com.awc20.spzx.model.vo.system.SysUserThreadLocalAuthContextUtil;
import com.awc20.spzx.util.MyAssert;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.UUID;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;


    @Override
    public LoginVo login(LoginDto loginDto) {
        //校验验证码
        String codeKey = loginDto.getCodeKey();
        String captcha = loginDto.getCaptcha();
        //从redis根据协同key拿到正确验证码
        String captchaCode = redisTemplate.opsForValue().get(codeKey);
        //对比验证码。
        MyAssert.isTrue(StringUtils.hasText(captchaCode)&&captchaCode.equals(captcha),"验证码错误");

        String password = loginDto.getPassword();
        String userName = loginDto.getUserName();
        SysUser sysUser = sysUserMapper.selectSysUserByName(userName);
        //排除用户名查找不到用户，用户名失效
        MyAssert.notNull(sysUser,"用户名无效");
        //进行密码对比
        String md5InputPassword = DigestUtils.md5DigestAsHex(password.getBytes());
        MyAssert.isTrue(md5InputPassword.equals(sysUser.getPassword()),"密码错误");
        //用UUID生成唯一token
        //存入redis缓存一份
        String token= UUID.randomUUID().toString().replace("-","");
        //JSON的转换格式为BrowserSecure ，将json字符串中文以%号等符号的形式保存。
        redisTemplate.opsForValue().set("user:login:" + token, JSON.toJSONString(sysUser, SerializerFeature.BrowserSecure));
        LoginVo loginVo = new LoginVo();
        loginVo.setToken(token);
        return loginVo;
    }

    @Override
    public SysUser getUserInfo(String token) {
/*        //需要根据token去redis缓存里取出用户信息。
        String sysUserJson = redisTemplate.opsForValue().get("user:login:"+token);
        if (sysUserJson.isEmpty()){
            return null;
        }
        //抓换用户信息为对象然后返回
        SysUser sysUser = JSON.parseObject(sysUserJson, SysUser.class);*/

        //有了拦截器之后，我们直接用存入本地线程的数据吧。
        SysUser sysUser = SysUserThreadLocalAuthContextUtil.get();
        return sysUser;
    }

    @Override
    public PageInfo<SysUser> getSysUserListByPage(int pageNum, int pageSize, SysUserDto sysUserDto) {
        PageHelper.startPage(pageNum,pageSize);
        List<SysUser> sysUserList = sysUserMapper.selectSysUserListByPage(sysUserDto);
        PageInfo<SysUser> pageInfo = new PageInfo<>(sysUserList);
        return pageInfo;
    }

    @Override
    public void saveSysUser(SysUser sysUser) {
        //这里不做用户、手机号等等不允许重复的逻辑校验。
        //用户密码是明文，这里需要加密处理。
        String password = sysUser.getPassword();
        String md5InputPassword = DigestUtils.md5DigestAsHex(password.getBytes());
        sysUser.setPassword(md5InputPassword);
        //设置一下用户状态
        sysUser.setStatus(1);
        sysUserMapper.insertSysUser(sysUser);
    }

    @Override
    public void updateSysUser(SysUser sysUser) {
        //这里不做密码更改。
        sysUserMapper.updateSysUser(sysUser);
    }


/*    public static void main(String[] args) throws Exception {
        Object o = new Object();
        o=null;
        *//*if(o==null){
            throw new Exception("对象不能为空");
        }*//*
        //使用断言来对一些数据校验有问题需要抛出异常的数据进行校验
        Assert.notNull(o,"断言：对象不能为空");
    }*/
}
