package com.awc20.spzx.manager.service.impl;

import com.awc20.spzx.manager.mapper.SysMenuMapper;
import com.awc20.spzx.manager.service.SysMenuService;
import com.awc20.spzx.manager.util.MenuHelper;
import com.awc20.spzx.model.entity.system.SysMenu;
import com.awc20.spzx.model.entity.system.SysUser;
import com.awc20.spzx.model.vo.system.SysMenuVo;
import com.awc20.spzx.model.vo.system.SysUserThreadLocalAuthContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Autowired
    SysMenuMapper sysMenuMapper;


    @Override
      public List<SysMenuVo> menus() {
        //查询出当前用户权限下菜单。
        SysUser sysUser = SysUserThreadLocalAuthContextUtil.get();
        List<SysMenu> sysMenuList = sysMenuMapper.selectSysMenuByUserId(sysUser.getId());
        //先把菜单组装成树
        List<SysMenu> menuTree = MenuHelper.buildTree(sysMenuList);
        //组装成需要的对象传给前端。
        //List<SysMenuVo> sysMenuVoList= MenuHelper.buildSysMenuVo(sysMenuList);

        List<SysMenuVo> sysMenuVoList = MenuHelper.buildMenuVos(menuTree);
        return sysMenuVoList;
    }

    @Override
    public List<SysMenu> findNodes() {
        List<SysMenu> sysMenuList = sysMenuMapper.selectAllMenus();
        List<SysMenu> tree = MenuHelper.buildTree(sysMenuList);
        return tree;
    }



    @Override
    public void saveSysMenu(SysMenu sysMenu) {
        sysMenuMapper.insertSysMenu(sysMenu);
    }

    @Override
    public void updateSysMenu(SysMenu sysMenu) {
        sysMenuMapper.updateSysMenu(sysMenu);
    }




/*    //查询组装子菜单的方法
    public SysMenuVo buildTree(SysMenu sysMenu,List<SysMenu> sysMenuList){
        SysMenuVo sysMenuVo = new SysMenuVo();
        sysMenuVo.setName(sysMenu.getComponent());
        sysMenuVo.setTitle(sysMenu.getTitle());
        sysMenuVo.setChildren(new ArrayList<>());
        for (SysMenu menu : sysMenuList) {
            if (menu.getParentId()==sysMenu.getId()){
                sysMenuVo.getChildren().add(buildTree(menu,sysMenuList));
            }
        }
        return sysMenuVo;
    }*/
}
