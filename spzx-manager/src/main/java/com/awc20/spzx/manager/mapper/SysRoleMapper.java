package com.awc20.spzx.manager.mapper;

import com.awc20.spzx.model.dto.system.SysRoleDto;
import com.awc20.spzx.model.entity.system.SysRole;

import java.util.List;

public interface SysRoleMapper {
    List<SysRole> selectSysRoleListByPage(SysRoleDto sysRoleDto);

    void insertSysRole(SysRole sysRole);

    void updateSysRole(SysRole sysRole);
}
