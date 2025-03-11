package com.awc20.spzx.manager.mapper;

import com.awc20.spzx.model.entity.system.SysMenu;

import java.util.List;

public interface SysMenuMapper {
    List<SysMenu> selectAllMenus();

    List<SysMenu> selectSysMenuByUserId(Long userId);

    void insertSysMenu(SysMenu sysMenu);

    void updateSysMenu(SysMenu sysMenu);
}
