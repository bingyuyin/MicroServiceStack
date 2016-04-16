package com.suiyu.microservices.config;

import com.suiyu.microservices.listener.MessageListener;
import com.suiyu.microservices.model.MicroServiceRegistry;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * Created by BingyuYin on 2016/4/15.
 */
@Configuration
public class MessageQueueConfiguration {
    @Autowired
    MicroServiceRegistry serviceRegistry;

    @Autowired
    private MessageListener listener;

    @Bean
    public MessageListenerAdapter microServiceListenerAdapter(){
        return new MessageListenerAdapter(listener, "handleMessage");
    }

    @Bean
    public SimpleMessageListenerContainer microServiceMessageListenerContainer(ConnectionFactory connectionFactory){
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        // TODO: set the queue name for the container
        container.setQueueNames(serviceRegistry.getQueueName());
        container.setMessageListener(microServiceListenerAdapter());
        return container;
    }
}
