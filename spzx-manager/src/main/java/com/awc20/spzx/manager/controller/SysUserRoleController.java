package com.awc20.spzx.manager.controller;

import com.awc20.spzx.manager.service.SysUserRoleService;
import com.awc20.spzx.model.dto.system.AssginRoleDto;
import com.awc20.spzx.model.vo.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/system/sysUserRole")
@CrossOrigin(allowCredentials = "true" , originPatterns = "*" , allowedHeaders = "*")
public class SysUserRoleController {


    @Autowired
    private SysUserRoleService sysUserRoleService;


    @PostMapping("/doAssign")
    public Result doAssign(@RequestBody AssginRoleDto assginRoleDto){
        sysUserRoleService.doAssign(assginRoleDto);
        return Result.ok(null);
    }



}
