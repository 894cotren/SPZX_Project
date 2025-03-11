package com.awc20.spzx.manager.controller;

import com.awc20.spzx.manager.service.SysRoleMenuService;
import com.awc20.spzx.model.dto.system.AssginMenuDto;
import com.awc20.spzx.model.vo.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/admin/system/sysRoleMenu/")
@CrossOrigin(allowCredentials = "true" , originPatterns = "*" , allowedHeaders = "*")

public class SysRoleMenuController {

    @Autowired
    SysRoleMenuService sysRoleMenuService;

    //给角色分配菜单的数据，需要全部菜单信息，以及角色对应的菜单id（回显已有菜单权限）
    @GetMapping("findSysRoleMenuByRoleId/{roleId}")
    public Result<Map<String,Object>> findSysRoleMenuByRoleId(@PathVariable Long roleId){
        // 调用业务层传入参数查询分页
        Map<String,Object> map = sysRoleMenuService.findSysRoleMenuByRoleId(roleId);
        return Result.ok(map);
    }

    @PostMapping("doAssign")
    public Result doAssign(@RequestBody AssginMenuDto assginMenuDto){
        sysRoleMenuService.doAssign(assginMenuDto);
        return Result.ok(null);
    }

}
