package com.suiyu.microservices.usermanagement.config;

import com.suiyu.microservices.common.MicroServiceConstants;
import com.suiyu.microservices.common.MicroServiceType;
import com.suiyu.microservices.model.MicroServiceRegistry;
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
        microServiceRegistry.setQueueName(MicroServiceConstants.SIMPLE_SERVICE_QUEUE_NAME);
        return microServiceRegistry;
    }
}
