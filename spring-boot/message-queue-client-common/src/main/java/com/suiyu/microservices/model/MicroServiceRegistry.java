package com.suiyu.microservices.model;

import com.suiyu.microservices.common.MicroServiceConstants;
import com.suiyu.microservices.common.MicroServiceType;
import org.springframework.stereotype.Component;

/**
 * Created by BingyuYin on 2016/4/16.
 */
@Component
public class MicroServiceRegistry {
    private MicroServiceType serviceType = MicroServiceType.simple_service;
    private String queueName = MicroServiceConstants.SIMPLE_SERVICE_QUEUE_NAME;

    public MicroServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(MicroServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public String getQueueName() {
        return queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }
}
