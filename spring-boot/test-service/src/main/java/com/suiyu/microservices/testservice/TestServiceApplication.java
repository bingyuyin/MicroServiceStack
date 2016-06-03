package com.suiyu.microservices.testservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by yinbing on 6/3/2016.
 */

@ComponentScan(basePackages = "com.suiyu.microservices")
@SpringBootApplication
public class TestServiceApplication {
    public static void main(String[] args) throws InterruptedException{
        SpringApplication.run(TestServiceApplication.class, args );
    }
}
