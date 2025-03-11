package com.awc20.spzx.manager.service;

import com.awc20.spzx.model.dto.system.SysRoleDto;
import com.awc20.spzx.model.entity.system.SysRole;
import com.github.pagehelper.PageInfo;

import java.util.Map;

public interface SysRoleService {
    PageInfo<SysRole> getSysRoleListByPage(Integer pageNum, Integer pageSize, SysRoleDto sysRoleDto);

    void saveSysRole(SysRole sysRole);

    void updateSysRole(SysRole sysRole);

    Map<String, Object> findAllRoles(Long sysUserId);
}
