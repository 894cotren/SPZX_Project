package com.awc20.spzx.manager.service;

import com.awc20.spzx.model.dto.system.LoginDto;
import com.awc20.spzx.model.dto.system.SysUserDto;
import com.awc20.spzx.model.entity.system.SysUser;
import com.awc20.spzx.model.vo.system.LoginVo;
import com.github.pagehelper.PageInfo;

public interface SysUserService {
    LoginVo login(LoginDto loginDto);

    SysUser getUserInfo(String token);

    PageInfo<SysUser> getSysUserListByPage(int pageNum, int pageSize, SysUserDto sysUserDto);

    void saveSysUser(SysUser sysUser);

    void updateSysUser(SysUser sysUser);
}

