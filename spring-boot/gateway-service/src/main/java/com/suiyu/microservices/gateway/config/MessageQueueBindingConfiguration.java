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
public class MessageQueueBindingConfiguration {
    @Autowired
    private AmqpAdmin amqpAdmin;

    @PostConstruct
    public void init() {
        amqpAdmin.declareQueue(simpleServiceQueue());
        amqpAdmin.declareQueue(infrastructureServiceQueue());
        amqpAdmin.declareQueue(userManagementServiceQueue());
    }

    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange(MicroServiceConstants.GATEWAY_FANOUT_EXCHANGE_NAME);
    }

    @Bean
    TopicExchange topicExchange() {
        return new TopicExchange(MicroServiceConstants.GATEWAY_TOPIC_EXCHANGE_NAME);
    }

    // Queues
    @Bean
    Queue simpleServiceQueue() {
        return new Queue(MicroServiceConstants.SIMPLE_SERVICE_QUEUE_NAME, false);
    }

    @Bean
    Queue infrastructureServiceQueue () {
        return new Queue(MicroServiceConstants.INFRASTRUCTURE_SERVICE_QUEUE_NAME, false);
    }

    @Bean
    Queue userManagementServiceQueue() {
        return new Queue(MicroServiceConstants.USER_MANAGEMENT_SERVICE_QUEUE_NAME, false);
    }

    // Topic Binding
    @Bean
    Binding simpleServiceTopicExchangeBinding() {
        return BindingBuilder.bind(simpleServiceQueue()).
                to(topicExchange()).
                with(MicroServiceConstants.SIMPLE_SERVICE_QUEUE_NAME);
    }

    @Bean
    Binding infrastructureServiceTopicExchangeBinding(){
        return BindingBuilder.bind(infrastructureServiceQueue()).
                to(topicExchange()).
                with(MicroServiceConstants.INFRASTRUCTURE_SERVICE_QUEUE_NAME);
    }

    @Bean
    Binding userManagementServiceTopicExchangeBinding(){
        return BindingBuilder.bind(userManagementServiceQueue()).
                to(topicExchange()).
                with(MicroServiceConstants.USER_MANAGEMENT_SERVICE_QUEUE_NAME);
    }

    // Fanout Binding
    @Bean
    Binding simpleServiceFanoutExchangeBinding(){
        return BindingBuilder.bind(simpleServiceQueue()).
                to(fanoutExchange());
    }

    @Bean
    Binding infrastructureServiceFanoutExchangeBinding () {
        return BindingBuilder.bind(infrastructureServiceQueue()).
                to(fanoutExchange());
    }

    @Bean
    Binding userManagementServiceFanoutExchangeBinding() {
        return BindingBuilder.bind(userManagementServiceQueue()).
                to(fanoutExchange());
    }

}
