package com.awc20.spzx.manager.util;

import com.awc20.spzx.model.entity.system.SysMenu;
import com.awc20.spzx.model.vo.system.SysMenuVo;

import java.util.ArrayList;
import java.util.List;

public class MenuHelper {
    public static List<SysMenu> buildTree(List<SysMenu> sysMenuList) {
        List<SysMenu> parent =new ArrayList<>();
        //找到顶级父节点
        for (SysMenu sysMenu : sysMenuList) {
            if (sysMenu.getParentId()==0){
                parent.add(findChild(sysMenu,sysMenuList));
            }
        }
        return parent;
    }


    private static SysMenu findChild(SysMenu parent, List<SysMenu> sysMenuList) {
        List<SysMenu> children=new ArrayList<>();
        for (SysMenu sysMenu : sysMenuList) {
            if (sysMenu.getParentId().longValue()==parent.getId().longValue()){
                children.add(findChild(sysMenu,sysMenuList));
            }
        }
        if (children.size()>0){
            parent.setChildren(children);
        }
        return parent;
    }

/*

    public static List<SysMenuVo> buildSysMenuVo(List<SysMenu> sysMenuList) {
        //先把菜单转换为树形结构
        List<SysMenu> treeMenu = buildTree(sysMenuList);
        //然后我们递归进去复制组转给SysMenuVo
        List<SysMenuVo> sysMenuVoList=new ArrayList<>();
        for (SysMenu menu : treeMenu) {
            SysMenuVo sysMenuVo = new SysMenuVo();
            sysMenuVo.setName(menu.getComponent());
            sysMenuVo.setTitle(menu.getTitle());
            if(menu.getChildren()!=null&& menu.getChildren().size()>0){
                sysMenuVo.setChildren(buildSysMenuVo(menu.getChildren()));
                //组装好了放入集合
            }
            sysMenuVoList.add(sysMenuVo);
        }
        return sysMenuVoList;
    }
*/


    public static List<SysMenuVo> buildMenuVos(List<SysMenu> sysMenusTree) {
        List<SysMenuVo> sysMenuVosTree = new ArrayList<>();
        // 将sysMenu的tree转化成sysMenuVo的tree
        for (SysMenu sysMenu : sysMenusTree) {
            SysMenuVo sysMenuVo = new SysMenuVo();
            sysMenuVo.setName(sysMenu.getComponent());
            sysMenuVo.setTitle(sysMenu.getTitle());
            if(sysMenu.getChildren()!=null&sysMenu.getChildren().size()>0){
                sysMenuVo.setChildren(buildMenuVos(sysMenu.getChildren()));
            }
            sysMenuVosTree.add(sysMenuVo);
        }
        return sysMenuVosTree;
    }

}
