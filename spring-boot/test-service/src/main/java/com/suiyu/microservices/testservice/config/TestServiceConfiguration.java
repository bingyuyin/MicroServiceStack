package com.suiyu.microservices.testservice.config;

import com.suiyu.microservices.common.MicroServiceConstants;
import com.suiyu.microservices.model.MicroServiceRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by yinbing on 6/3/2016.
 */
@Configuration
public class TestServiceConfiguration {
    @Bean
    public MicroServiceRegistry microServiceRegistry() {
        MicroServiceRegistry microServiceRegistry = new MicroServiceRegistry();
        microServiceRegistry.setServiceName("TEST-SERVICE");
        microServiceRegistry.setServiceTopic(MicroServiceConstants.REQUEST_EXCHANGE_NAME);
        microServiceRegistry.setServiceBroadcast(MicroServiceConstants.BROADCAST_EXCHANGE_NAME);
        return microServiceRegistry;
    }
}
