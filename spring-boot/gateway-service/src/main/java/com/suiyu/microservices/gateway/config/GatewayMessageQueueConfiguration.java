package com.suiyu.microservices.gateway.config;

import com.suiyu.microservices.common.MicroServiceConstants;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * Created by BingyuYin on 2016/4/16.
 */
@Configuration
public class GatewayMessageQueueConfiguration {
    @Autowired
    private AmqpAdmin amqpAdmin;

    @PostConstruct
    public void init() {
        amqpAdmin.declareExchange(requestExchange());
        amqpAdmin.declareExchange(broadcastExchange());
        amqpAdmin.declareExchange(replyExchange());
    }

    @Bean(name = "broadcastExchange")
    FanoutExchange broadcastExchange() {
        return new FanoutExchange(MicroServiceConstants.BROADCAST_EXCHANGE_NAME);
    }

    @Bean(name = "requestExchange")
    TopicExchange requestExchange() {
        return new TopicExchange(MicroServiceConstants.REQUEST_EXCHANGE_NAME);
    }

    @Bean(name = "replyExchange")
    TopicExchange replyExchange(){
        return new TopicExchange(MicroServiceConstants.REPLY_EXCHANGE_NAME);
    }



}
