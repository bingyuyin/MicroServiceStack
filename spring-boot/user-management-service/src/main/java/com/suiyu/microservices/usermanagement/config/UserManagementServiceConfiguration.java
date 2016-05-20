package com.suiyu.microservices.usermanagement.config;

import com.suiyu.microservices.common.MicroServiceConstants;
import com.suiyu.microservices.common.type.MicroServiceType;
import com.suiyu.microservices.model.MicroServiceRegistry;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by BingyuYin on 2016/4/17.
 */
@Configuration
public class UserManagementServiceConfiguration {
    @Bean
    MicroServiceRegistry microServiceRegistry() {
        MicroServiceRegistry microServiceRegistry = new MicroServiceRegistry();
        microServiceRegistry.setServiceType(MicroServiceType.user_management_service);
        microServiceRegistry.setQueueName(MicroServiceConstants.USER_MANAGEMENT_SERVICE_QUEUE_NAME);
        microServiceRegistry.setRoutingKey(MicroServiceConstants.USER_MANAGEMENT_SERVICE_QUEUE_NAME);
        microServiceRegistry.setRequestExchange(new TopicExchange(MicroServiceConstants.REQUEST_EXCHANGE_NAME));
        microServiceRegistry.setBroadcastExchange(new FanoutExchange(MicroServiceConstants.BROADCAST_EXCHANGE_NAME));
        return microServiceRegistry;
    }
}
