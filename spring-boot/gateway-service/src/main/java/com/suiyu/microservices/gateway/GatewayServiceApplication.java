package com.suiyu.microservices.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by BingyuYin on 2016/4/16.
 */
@ComponentScan(basePackages = "com.suiyu.microservices")
@EnableAutoConfiguration
public class GatewayServiceApplication {
    public static void main (String[] args) throws InterruptedException {
        SpringApplication.run(GatewayServiceApplication.class, args);
    }
}
