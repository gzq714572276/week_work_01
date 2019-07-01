package com.zjw.user_manager_user;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.zjw")
@DubboComponentScan("com.zjw.serviceimpl")
@MapperScan("com.zjw.dao")
public class UserManagerUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserManagerUserApplication.class, args);
    }

}
