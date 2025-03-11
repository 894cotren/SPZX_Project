package com.awc20.spzx.manager.service.impl;

import com.awc20.spzx.manager.mapper.SysMenuMapper;
import com.awc20.spzx.manager.mapper.SysRoleMenuMapper;
import com.awc20.spzx.manager.service.SysRoleMenuService;
import com.awc20.spzx.manager.util.MenuHelper;
import com.awc20.spzx.model.dto.system.AssginMenuDto;
import com.awc20.spzx.model.entity.system.SysMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysRoleMenuServiceImpl implements SysRoleMenuService {

    @Autowired
    SysRoleMenuMapper sysRoleMenuMapper;

    @Autowired
    SysMenuMapper sysMenuMapper;

    @Override
    public Map<String, Object> findSysRoleMenuByRoleId(Long roleId) {
        //查询到所有菜单信息
        List<SysMenu> sysMenuList = sysMenuMapper.selectAllMenus();
        //组装菜单为树
        List<SysMenu> menuTree = MenuHelper.buildTree(sysMenuList);
        //查询到角色所对应的菜单ID
        List<Long> ids =sysRoleMenuMapper. selectSysRoleMenuIdsByRoleId(roleId);
        Map<String, Object> result=new HashMap<>();
        result.put("sysMenuList",menuTree);
        result.put("roleMenuIds",ids);
        return result;
    }

    @Override
    public void doAssign(AssginMenuDto assginMenuDto) {
        //先删除
        sysRoleMenuMapper.deleteByRoleId(assginMenuDto.getRoleId());
        //后添加
        sysRoleMenuMapper.insertSysRoleMenu(assginMenuDto);

    }
}
