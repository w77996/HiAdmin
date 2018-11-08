package com.w77996.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.w77996.admin.dao")
public class HiAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(HiAdminApplication.class, args);
    }
}
