package com.awc20.spzx.manager.controller;

import com.awc20.spzx.manager.service.SysUserService;
import com.awc20.spzx.model.dto.system.SysUserDto;
import com.awc20.spzx.model.entity.system.SysUser;
import com.awc20.spzx.model.vo.common.Result;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("admin/system/sysUser/")
@CrossOrigin(allowCredentials = "true" , originPatterns = "*" , allowedHeaders = "*")
public class SysUserController {


    @Autowired
    private SysUserService sysUserService;

    //用户管理界面加载的一组用户分页数据。
    @GetMapping("getSysUserListByPage/{pageNum}/{pageSize}")
    public Result<PageInfo<SysUser>> getSysUserListByPage(@PathVariable int pageNum,@PathVariable int pageSize,
                                                          SysUserDto sysUserDto){
        PageInfo<SysUser> pageInfo = sysUserService.getSysUserListByPage(pageNum,pageSize,sysUserDto);
        return Result.ok(pageInfo);
    }


    @PostMapping("/saveSysUser")
    public Result saveSysUser (@RequestBody SysUser sysUser){
        sysUserService.saveSysUser(sysUser);
        return  Result.ok("添加成功");
    }

    @PutMapping("/updateSysUser")
    public Result updateSysUser(@RequestBody SysUser sysUser){
        sysUserService.updateSysUser(sysUser);
        return  Result.ok("更改成功");
    }
}
