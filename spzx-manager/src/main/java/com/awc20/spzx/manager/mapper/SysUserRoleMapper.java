package com.awc20.spzx.manager.mapper;

import com.awc20.spzx.model.dto.system.AssginRoleDto;

import java.util.List;

public interface SysUserRoleMapper {
    List<Long> findRoleIdBySysUserId(Long sysUserId);

    void deleteByUserId(Long userId);

    void insertUserRole(AssginRoleDto assginRoleDto);

}
