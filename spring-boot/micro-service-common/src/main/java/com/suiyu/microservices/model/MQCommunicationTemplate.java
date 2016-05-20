package com.suiyu.microservices.model;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 * Created by BingyuYin on 2016/4/15.
 */
@Component
public interface MQCommunicationTemplate {
    void send(Object message, String exchange, String routingKey);
    Object receiveOnly(String queueName);
    Object receiveOnly(String queueName, long timeoutMs);
    Object receive(String queueName, long timeoutMs);
    Object receive(String queueName);
    Object sendAndReceiveOnly(Object message, String sendToExchange, String sendToRoutingKey, String receiveQueueName);
    Object sendAndReceiveOnly(Object message, String sendToExchange, String sendToRoutingKey, String receiveQueueName, long timeoutMs);
    Object sendAndReceive(Object message, String sendToExchange, String sendToRoutingKey, String receiveQueueName);
    Object sendAndReceive(Object message, String sendToExchange, String sendToRoutingKey, String receiveQueueName, long timeoutMs);
    @Deprecated
    void broadcast(Object message, String topic);
    @Deprecated
    Object broadcastAndReceive(Object message, String topic);
    @Deprecated
    Object sendAndReceive(Object message, String topic, String queueName);
    @Deprecated
    ResponseEntity<Object> sendAndReceiveResponseEntity(Object message, String topic, String queueName);
}
