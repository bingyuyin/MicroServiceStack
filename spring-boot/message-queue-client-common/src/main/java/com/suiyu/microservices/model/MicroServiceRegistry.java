package com.suiyu.microservices.model;

import com.suiyu.microservices.common.MicroServiceConstants;
import com.suiyu.microservices.common.type.MicroServiceType;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.stereotype.Component;

/**
 * Created by BingyuYin on 2016/4/16.
 */
@Component
public class MicroServiceRegistry {
    private MicroServiceType serviceType = MicroServiceType.simple_service;
    private String queueName = MicroServiceConstants.SIMPLE_SERVICE_QUEUE_NAME;
    private String routingKey = MicroServiceConstants.SIMPLE_SERVICE_QUEUE_NAME;
    private TopicExchange requestExchange = null;
    private FanoutExchange broadcastExchange = null;

    public String getRoutingKey() {
        return routingKey;
    }

    public void setRoutingKey(String routingKey) {
        this.routingKey = routingKey;
    }

    public FanoutExchange getBroadcastExchange() {
        return broadcastExchange;
    }

    public void setBroadcastExchange(FanoutExchange broadcastExchange) {
        this.broadcastExchange = broadcastExchange;
    }

    public TopicExchange getRequestExchange() {
        return requestExchange;
    }

    public void setRequestExchange(TopicExchange requestExchange) {
        this.requestExchange = requestExchange;
    }

    public MicroServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(MicroServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public String getQueueName() {
        return queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }

}
