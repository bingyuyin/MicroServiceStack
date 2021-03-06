package com.suiyu.microservices.model.impl;

import com.suiyu.microservices.common.MicroServiceResponse;
import com.suiyu.microservices.model.MQCommunicationTemplate;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 * Created by BingyuYin on 2016/4/16.
 */
@Component("rabbitMQCommunicationTemplateImpl")
public class RabbitMQCommunicationTemplateImpl implements MQCommunicationTemplate {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private AmqpAdmin amqpAdmin;

    @Override
    public void send(Object message, String exchange, String routingKey) {
        rabbitTemplate.convertAndSend(exchange, routingKey, message);
    }

    @Override
    public Object receiveOnly(String queueName) {
        return receiveOnly(queueName, 3000);
    }

    @Override
    public Object receiveOnly(String queueName, long timeoutMs) {
        rabbitTemplate.setReceiveTimeout(timeoutMs);
        return rabbitTemplate.receiveAndConvert(queueName);
    }

    @Override
    public Object sendAndReceiveOnly(Object message, String sendToExchange, String sendToRoutingKey, String receiveQueueName) {
        return sendAndReceiveOnly(message, sendToExchange, sendToRoutingKey, receiveQueueName, 3000);
    }

    @Override
    public Object sendAndReceiveOnly(Object message, String sendToExchange, String sendToRoutingKey, String receiveQueueName, long timeoutMs) {
        send(message, sendToExchange, sendToRoutingKey);
        return receiveOnly(receiveQueueName, timeoutMs);
    }

    @Override
    public Object receive(String queueName, long timeoutMs) {
        Object res = receiveOnly(queueName, timeoutMs);
        amqpAdmin.deleteQueue(queueName);
        return res;
    }

    @Override
    public Object receive(String queueName) {
        return receive(queueName, 3000);
    }

    @Override
    public Object sendAndReceive(Object message, String sendToExchange, String sendToRoutingKey, String receiveQueueName) {
        return sendAndReceive(message, sendToExchange, sendToRoutingKey, receiveQueueName, 3000);
    }

    @Override
    public Object sendAndReceive(Object message, String sendToExchange, String sendToRoutingKey, String receiveQueueName, long timeoutMs) {
        Object res = sendAndReceiveOnly(message, sendToExchange, sendToRoutingKey, receiveQueueName, timeoutMs);
        amqpAdmin.deleteQueue(receiveQueueName);
        return res;
    }

    public void broadcast(Object message, String topic) {
        rabbitTemplate.convertAndSend(topic, null, message);
    }

    public Object broadcastAndReceive(Object message, String topic) {
        return rabbitTemplate.convertSendAndReceive(topic, null, message);
    }



    public Object sendAndReceive(Object message, String topic, String queueName) {
        return rabbitTemplate.convertSendAndReceive(topic, queueName, message);
    }

    public ResponseEntity<Object> sendAndReceiveResponseEntity(Object message, String topic, String queueName) {
        Object response = sendAndReceive(message, topic, queueName);
        if ( response instanceof MicroServiceResponse) {
            if ( ((MicroServiceResponse) response).getResponseCode() == 0 ) {
                return new ResponseEntity<Object>(response, HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }
}
