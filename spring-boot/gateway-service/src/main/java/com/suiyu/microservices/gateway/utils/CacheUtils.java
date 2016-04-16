package com.suiyu.microservices.gateway.utils;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

/**
 * Created by BingyuYin on 2016/4/16.
 */
public class CacheUtils {
    private CacheUtils() {

    }

    public static RabbitTemplate rabbitTemplate = null;
}
