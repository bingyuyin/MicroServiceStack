package com.suiyu.microservices.config;

import com.suiyu.microservices.listener.MessageListener;
import com.suiyu.microservices.model.MicroServiceRegistry;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * Created by BingyuYin on 2016/4/15.
 */
@Configuration
public class MessageQueueConfiguration {

    @Autowired
    MicroServiceRegistry serviceRegistry;

    @Autowired
    AmqpAdmin amqpAdmin;

    @Autowired
    private MessageListener listener;

    @Bean
    public MessageListenerAdapter microServiceListenerAdapter(){
        return new MessageListenerAdapter(listener, "doHandle");
    }

    @Bean
    public SimpleMessageListenerContainer microServiceMessageListenerContainer(ConnectionFactory connectionFactory){
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        // TODO: set the queue name for the container
        container.setQueueNames(serviceRegistry.getServiceQueueName());
        container.setMessageListener(microServiceListenerAdapter());
        return container;
    }

    @Bean
    public Queue serviceQueue(){
        return new Queue(serviceRegistry.getServiceQueueName());
    }

    @Bean
    public Binding serviceQueueRequestBinding() {
        return  BindingBuilder.bind(serviceQueue())
                .to(serviceRegistry.getServiceTopicExchange())
                .with(serviceRegistry.getRoutingKey());
    }

    @Bean Binding serviceQueueBroadcastBinding() {
        return BindingBuilder.bind(serviceQueue())
                .to(serviceRegistry.getBroadcastTopicExchange());
    }

    @PostConstruct
    public void initMsgQueueConfig() {
        amqpAdmin.declareQueue(serviceQueue());
        amqpAdmin.declareBinding(serviceQueueBroadcastBinding());
        amqpAdmin.declareBinding(serviceQueueRequestBinding());
    }
}
