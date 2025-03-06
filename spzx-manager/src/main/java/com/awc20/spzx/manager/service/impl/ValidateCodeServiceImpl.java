package com.awc20.spzx.manager.service.impl;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import com.awc20.spzx.manager.service.ValidateCodeService;
import com.awc20.spzx.model.vo.system.ValidateCodeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class ValidateCodeServiceImpl implements ValidateCodeService {


    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Override
    public ValidateCodeVo generateValidateCode() {
        //糊涂工具包生成验证码
        CircleCaptcha circleCaptcha = CaptchaUtil.createCircleCaptcha(100, 40, 4, 3);
        String key = UUID.randomUUID().toString().replace("-","");
        String code = circleCaptcha.getCode();
        String imageBase64Data = circleCaptcha.getImageBase64Data();
        //key+验证码存储一份到redis用于验证
        redisTemplate.opsForValue().set(key,code,2, TimeUnit.MINUTES);
        ValidateCodeVo validateCodeVo = new ValidateCodeVo();
        validateCodeVo.setCodeKey(key);
        validateCodeVo.setCodeValue(imageBase64Data);
        return validateCodeVo;
    }


/*    public static void main(String[] args) {
        String key = UUID.randomUUID().toString().replace("-","");
        System.out.println(key);
    }*/
}
