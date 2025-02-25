package com.awc20.spzx.manager.controller;

import com.awc20.spzx.manager.service.SysUserService;
import com.awc20.spzx.model.dto.system.LoginDto;
import com.awc20.spzx.model.entity.system.SysUser;
import com.awc20.spzx.model.vo.common.Result;
import com.awc20.spzx.model.vo.system.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/system/index/")
@CrossOrigin(allowCredentials = "true" , originPatterns = "*" , allowedHeaders = "*")
public class IndexController {

    @Autowired
    private SysUserService sysUserService;

    @PostMapping("/login")
    public Result<LoginVo> login(@RequestBody LoginDto loginDto) {
        LoginVo loginVo= sysUserService.login(loginDto);
        if (loginVo == null) {
            return Result.fail("用户名或密码错误");
        }
        return Result.ok(loginVo);
    }


    @GetMapping("/getUserInfo")
    public Result<SysUser> getUserInfo(String token){
        SysUser sysUser = sysUserService.getUserInfo(token);
        return Result.ok(sysUser);
    }
}


