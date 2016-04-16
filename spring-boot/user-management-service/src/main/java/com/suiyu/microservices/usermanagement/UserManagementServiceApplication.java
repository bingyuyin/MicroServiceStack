package com.suiyu.microservices.usermanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by BingyuYin on 2016/4/17.
 */
@ComponentScan(basePackages = "com.suiyu.microservices")
@EnableAutoConfiguration
public class UserManagementServiceApplication {
    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(UserManagementServiceApplication.class, args);
    }
}
