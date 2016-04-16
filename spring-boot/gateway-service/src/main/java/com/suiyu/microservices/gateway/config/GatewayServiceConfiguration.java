package com.suiyu.microservices.gateway.config;

import com.suiyu.microservices.common.MicroServiceType;
import com.suiyu.microservices.gateway.utils.CacheUtils;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * Created by BingyuYin on 2016/4/16.
 */
@Configuration
public class GatewayServiceConfiguration {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostConstruct
    public void init() {
        CacheUtils.rabbitTemplate = rabbitTemplate;
    }

}
