package com.awc20.spzx.manager.service.impl;

import cn.hutool.Hutool;
import com.awc20.spzx.manager.mapper.SysUserMapper;
import com.awc20.spzx.manager.service.SysUserService;
import com.awc20.spzx.model.dto.system.LoginDto;
import com.awc20.spzx.model.entity.system.SysUser;
import com.awc20.spzx.model.vo.system.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.UUID;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public LoginVo login(LoginDto loginDto) {
        String password = loginDto.getPassword();
        String userName = loginDto.getUserName();
        SysUser sysUser = sysUserMapper.selectSysUserByName(userName);
        //排除用户名查找不到用户，用户名失效
        if (sysUser == null) {
            return null;
        }
        //进行密码对比
        String md5InputPassword = DigestUtils.md5DigestAsHex(password.getBytes());
        if (!md5InputPassword.equals(sysUser.getPassword())){
            //不匹配
            return null;
        }

        //生成唯一token
        //存入redis缓存一份
        String token= UUID.randomUUID().toString().replace("-","");
        LoginVo loginVo = new LoginVo();
        loginVo.setToken(token);
        return loginVo;
    }

    @Override
    public SysUser getUserInfo(String token) {
        //需要根据token去redis缓存里取出用户信息。
        //这里暂时做一个假的
        SysUser sysUser = new SysUser();
        sysUser.setName("张三");
        sysUser.setUserName("zhangsan");
        return sysUser;
    }
}
