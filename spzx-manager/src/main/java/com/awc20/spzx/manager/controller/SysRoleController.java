package com.awc20.spzx.manager.controller;

import com.awc20.spzx.manager.service.SysRoleService;
import com.awc20.spzx.model.dto.system.SysRoleDto;
import com.awc20.spzx.model.entity.system.SysRole;
import com.awc20.spzx.model.vo.common.Result;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/system/sysRole/")
@CrossOrigin(allowCredentials = "true" , originPatterns = "*" , allowedHeaders = "*")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;


    //分页查询角色--可能有的条件----角色名
    @GetMapping("getSysRoleListByPage/{pageNum}/{pageSize}")
    public Result<PageInfo<SysRole>> getSysRoleListByPage(@PathVariable Integer pageNum , @PathVariable Integer pageSize,
                                                          SysRoleDto sysRoleDto){

        PageInfo<SysRole> pageInfo=sysRoleService.getSysRoleListByPage(pageNum,pageSize,sysRoleDto);
        return Result.ok(pageInfo);
    }


    //添加角色
    @PostMapping("/saveSysRole")
    public Result saveSysRole(@RequestBody SysRole sysRole){
        sysRoleService.saveSysRole(sysRole);
        return Result.ok("添加成功");
    }

    @PutMapping("updateSysRole")
    public Result updateSysRole(@RequestBody SysRole sysRole){
        sysRoleService.updateSysRole(sysRole);
        return Result.ok("修改成功");
    }


}
