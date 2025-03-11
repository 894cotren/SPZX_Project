package com.awc20.spzx.manager.service;

import com.awc20.spzx.model.entity.system.SysMenu;
import com.awc20.spzx.model.vo.system.SysMenuVo;

import java.util.List;

public interface SysMenuService {
    List<SysMenuVo> menus();

    List<SysMenu> findNodes();

    void saveSysMenu(SysMenu sysMenu);

    void updateSysMenu(SysMenu sysMenu);
}
