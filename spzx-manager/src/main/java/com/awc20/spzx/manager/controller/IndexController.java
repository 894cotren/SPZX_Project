package com.awc20.spzx.manager.controller;

import cn.hutool.Hutool;
import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import com.awc20.spzx.manager.service.SysUserService;
import com.awc20.spzx.manager.service.ValidateCodeService;
import com.awc20.spzx.model.dto.system.LoginDto;
import com.awc20.spzx.model.entity.system.SysUser;
import com.awc20.spzx.model.vo.common.Result;
import com.awc20.spzx.model.vo.system.LoginVo;
import com.awc20.spzx.model.vo.system.ValidateCodeVo;
import com.awc20.spzx.util.MyAssert;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/system/index/")
@CrossOrigin(allowCredentials = "true" , originPatterns = "*" , allowedHeaders = "*")
public class IndexController {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private ValidateCodeService validateCodeService;

    @PostMapping("/login")
    public Result<LoginVo> login(@RequestBody LoginDto loginDto) {
        LoginVo loginVo= sysUserService.login(loginDto);
        MyAssert.notNull(loginVo,"用户名或密码错误");
        return Result.ok(loginVo);
    }


    //登录后获取用户的基础信息等。
    @GetMapping("/getUserInfo")
    public Result<SysUser> getUserInfo(HttpServletRequest request){
        String token = request.getHeader("token");
        SysUser sysUser = sysUserService.getUserInfo(token);
        return Result.ok(sysUser);
    }

    //获取验证码
    @GetMapping(value = "/generateValidateCode")
    public Result<ValidateCodeVo> generateValidateCode() {
        ValidateCodeVo validateCodeVo = validateCodeService.generateValidateCode();
        return Result.ok(validateCodeVo);
    }

/*    public static void main(String[] args) {
        //糊涂工具包生成验证码
        CircleCaptcha circleCaptcha = CaptchaUtil.createCircleCaptcha(80, 20, 4, 4);
        String code = circleCaptcha.getCode();
        String imageBase64Data = circleCaptcha.getImageBase64Data();
        System.out.println(code);
        System.out.println(imageBase64Data);
    }*/
}


