package com.awc20.spzx.manager;

import com.awc20.spzx.common.anno.EnbaleGlobalExceptionHandler;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.awc20.spzx.manager.mapper;")
@EnbaleGlobalExceptionHandler
public class ManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManagerApplication.class, args);
    }
}
