package com.awc20.spzx.manager.mapper;

import com.awc20.spzx.model.dto.system.SysUserDto;
import com.awc20.spzx.model.entity.system.SysUser;

import java.util.List;

public interface SysUserMapper {
    SysUser selectSysUserByName(String userName);

    List<SysUser> selectSysUserListByPage(SysUserDto sysUserDto);

    void insertSysUser(SysUser sysUser);

    void updateSysUser(SysUser sysUser);

}
