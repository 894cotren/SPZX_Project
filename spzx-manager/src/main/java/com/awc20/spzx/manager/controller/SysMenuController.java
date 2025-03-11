package com.awc20.spzx.manager.controller;

import com.awc20.spzx.manager.service.SysMenuService;
import com.awc20.spzx.model.entity.system.SysMenu;
import com.awc20.spzx.model.vo.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/system/sysMenu/")
@CrossOrigin(allowCredentials = "true" , originPatterns = "*" , allowedHeaders = "*")
public class SysMenuController {

    @Autowired
    private SysMenuService sysMenuService;

    @GetMapping("/findNodes")
    public Result<List<SysMenu>> findNodes() {
        List<SysMenu> list = sysMenuService.findNodes();
        return Result.ok(list) ;
    }


    @PostMapping("saveSysMenu")
    public Result saveSysMenu(@RequestBody SysMenu sysMenu){
        sysMenuService.saveSysMenu(sysMenu);
        return Result.ok(null);
    }

    @PutMapping("updateSysMenu")
    public Result updateSysMenu(@RequestBody SysMenu sysMenu){
        sysMenuService.updateSysMenu(sysMenu);
        return Result.ok(null);
    }

}
