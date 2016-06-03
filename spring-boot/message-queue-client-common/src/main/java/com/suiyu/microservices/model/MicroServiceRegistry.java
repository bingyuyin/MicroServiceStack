package com.suiyu.microservices.model;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.stereotype.Component;

/**
 * Created by BingyuYin on 2016/4/16.
 */
public class MicroServiceRegistry {
    private String serviceName = null;
    private String serviceTopic = null;
    private String serviceBroadcast = null;
    private String routingKey = null;

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceTopic() {
        return serviceTopic;
    }

    public void setServiceTopic(String serviceTopic) {
        this.serviceTopic = serviceTopic;
    }

    public String getServiceBroadcast() {
        return serviceBroadcast;
    }

    public void setServiceBroadcast(String serviceBroadcast) {
        this.serviceBroadcast = serviceBroadcast;
    }

    public String getRoutingKey() {
        if (null == routingKey) {
            return getServiceQueueName();
        }
        return routingKey;
    }

    public void setRoutingKey(String routingKey) {
        this.routingKey = routingKey;
    }

    public String getServiceQueueName() {
        return serviceName + "-QUEUE";
    }

    public TopicExchange getServiceTopicExchange() {
        return new TopicExchange(serviceTopic);
    }

    public FanoutExchange getBroadcastTopicExchange() {
        return new FanoutExchange(serviceBroadcast);
    }

}
