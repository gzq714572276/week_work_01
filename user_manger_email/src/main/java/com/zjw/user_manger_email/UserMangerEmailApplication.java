package com.zjw.user_manger_email;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.zjw")
@DubboComponentScan("com.zjw.serviceimpl")
public class UserMangerEmailApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserMangerEmailApplication.class, args);
    }

}
