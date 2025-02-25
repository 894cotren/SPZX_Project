package com.awc20.spzx.manager.service;

import com.awc20.spzx.model.dto.system.LoginDto;
import com.awc20.spzx.model.entity.system.SysUser;
import com.awc20.spzx.model.vo.system.LoginVo;

public interface SysUserService {
    LoginVo login(LoginDto loginDto);

    SysUser getUserInfo(String token);
}
