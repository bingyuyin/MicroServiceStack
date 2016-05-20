package com.suiyu.microservices.model;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.stereotype.Component;

/**
 * Created by yinbing on 5/20/2016.
 */
@Component
public interface MQAdmin {
    String createTempQueueAndBindingToTopicExchangeWithName(String exchangeName, String prefix);
    void clearQueue(String queueName);
}
