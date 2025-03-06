package com.awc20.spzx.model.dto.system;

import lombok.Data;

// com.atguigu.spzx.model.dto.system
@Data
public class LoginDto {

    private String userName ;
    private String password ;
    //验证码
    private String captcha ;
    //验证码所协同的key
    private String codeKey ;

}