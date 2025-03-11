package com.awc20.spzx.manager.mapper;

import com.awc20.spzx.model.dto.system.AssginMenuDto;

import java.util.List;

public interface SysRoleMenuMapper {
    List<Long> selectSysRoleMenuIdsByRoleId(Long roleId);

    void deleteByRoleId(Long roleId);

    void insertSysRoleMenu(AssginMenuDto assginMenuDto);

}
