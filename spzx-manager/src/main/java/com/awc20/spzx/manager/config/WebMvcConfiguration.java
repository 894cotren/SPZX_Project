package com.awc20.spzx.manager.config;

import com.awc20.spzx.manager.interceptor.LoginAuthInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class WebMvcConfiguration implements WebMvcConfigurer {

    @Autowired
    LoginAuthInterceptor loginAuthInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginAuthInterceptor)
                //这里排除登录和验证码，其他都拦截下来。
                .excludePathPatterns("/admin/system/index/login" , "/admin/system/index/generateValidateCode")
                .addPathPatterns("/**");
    }



}
