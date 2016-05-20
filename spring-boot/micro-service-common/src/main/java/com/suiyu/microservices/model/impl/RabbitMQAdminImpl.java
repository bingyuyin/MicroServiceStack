package com.suiyu.microservices.model.impl;

import com.suiyu.microservices.model.MQAdmin;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by yinbing on 5/20/2016.
 */
@Component
public class RabbitMQAdminImpl implements MQAdmin {

    private Map<String, TopicExchange> topicExchangeMap = new ConcurrentHashMap<String, TopicExchange>();
    private Map<String, FanoutExchange> fanoutExchangeMap = new ConcurrentHashMap<String, FanoutExchange>();

    private <T extends AbstractExchange> T getExchange(Class<T> clazz, String exchangeName) {
        Map<String, ? extends AbstractExchange> map = null;
        if (clazz.equals(TopicExchange.class)) {
            map = topicExchangeMap;
        } else if (clazz.equals(FanoutExchange.class)) {
            map = fanoutExchangeMap;
        }

        if (map == null){
            return null;
        }

        if(map.containsKey(exchangeName)) {
            return (T)map.get(exchangeName);
        }
        return addExchange(clazz, exchangeName);
    }

    private <T extends AbstractExchange> T addExchange(Class<T> clazz, String exchangeName) {
        Object res = null;
        if (clazz.equals(TopicExchange.class)) {
            res = new TopicExchange(exchangeName);
            topicExchangeMap.put(exchangeName, (TopicExchange)res);
        } else if (clazz.equals(FanoutExchange.class)) {
            res = new FanoutExchange(exchangeName);
            fanoutExchangeMap.put(exchangeName, (FanoutExchange)res);
        }
        return (T)res;
    }


    @Autowired
    private AmqpAdmin amqpAdmin;

    @Override
    public String createTempQueueAndBindingToTopicExchangeWithName(String exchangeName, String prefix) {
        String tempId = UUID.randomUUID().toString();
        String queueName = prefix + tempId;
        Queue queue = new Queue(queueName);
        TopicExchange exchange = getExchange(TopicExchange.class, exchangeName);
        amqpAdmin.declareQueue(queue);
        amqpAdmin.declareBinding(BindingBuilder.bind(queue)
                .to(exchange)
                .with(queueName));
        return queueName;
    }

    @Override
    public void clearQueue(String queueName) {
        amqpAdmin.deleteQueue(queueName);
    }
}
