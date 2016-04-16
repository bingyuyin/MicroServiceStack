package com.suiyu.microservices.model;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 * Created by BingyuYin on 2016/4/15.
 */
@Component
public interface MQCommunicationTemplate {
    void broadcast(Object message, String topic);
    Object broadcastAndReceive(Object message, String topic);
    void send(Object message, String topic, String queueName);
    Object sendAndReceive(Object message, String topic, String queueName);
    ResponseEntity<Object> sendAndReceiveResponseEntity(Object message, String topic, String queueName);
}
