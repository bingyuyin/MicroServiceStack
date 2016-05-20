package com.suiyu.microservices.common;

/**
 * Created by BingyuYin on 2016/4/16.
 */
public class MicroServiceConstants {
    private MicroServiceConstants () {

    }

    public static final String REQUEST_EXCHANGE_NAME = "REQUEST-EXCHANGE";
    public static final String BROADCAST_EXCHANGE_NAME = "BROADCAST-EXCHANGE";
    public static final String REPLY_EXCHANGE_NAME = "REPLY-EXCHANGE";
    public static final String GATEWAY_FANOUT_EXCHANGE_NAME = "GATEWAY-FANOUT-EXCHANGE";
    public static final String GATEWAY_TOPIC_EXCHANGE_NAME = "GATEWAY-TOPIC-EXCHANGE";
    public static final String SIMPLE_SERVICE_QUEUE_NAME = "SIMPLE-SERVICE-QUEUE";
    public static final String USER_MANAGEMENT_SERVICE_QUEUE_NAME = "USER-MANAGEMENT-SERVICE-QUEUE";
    public static final String INFRASTRUCTURE_SERVICE_QUEUE_NAME = "INFRASTRUCTURE-SERVICE-QUEUE";
}
