package com.awc20.spzx.manager.controller;

import com.awc20.spzx.manager.service.SysRoleService;
import com.awc20.spzx.model.dto.system.SysRoleDto;
import com.awc20.spzx.model.entity.system.SysRole;
import com.awc20.spzx.model.vo.common.Result;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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


    //分配角色功能，根据传入的用户ID，我们需要查询到所有角色数据，以及用户已关联上的角色ID。
    //所以我们需要返回一个Map集合装两个list集合。一个list装所有角色数据，一个list装用户关联的角色ID
    @GetMapping("/findAllRoles/{sysUserId}")
    public Result<Map<String,Object>> findAllRoles(@PathVariable Long sysUserId){
        Map<String,Object> roleMap = sysRoleService.findAllRoles(sysUserId);
        return Result.ok(roleMap);
    }

}
