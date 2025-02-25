package com.awc20.spzx.manager.mapper;

import com.awc20.spzx.model.entity.system.SysUser;

public interface SysUserMapper {
    SysUser selectSysUserByName(String userName);

}
