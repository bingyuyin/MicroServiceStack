package com.suiyu.microservices.listener.impl;

import com.suiyu.microservices.common.MicroServiceRequest;
import com.suiyu.microservices.common.MicroServiceType;
import com.suiyu.microservices.listener.MessageListener;
import com.suiyu.microservices.model.MicroServiceRegistry;
import com.suiyu.microservices.service.HandlerInvokeService;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by BingyuYin on 2016/4/15.
 */
@Component
public class SimpleMessageListenerImpl implements MessageListener {

    @Autowired
    private MicroServiceRegistry serviceRegistry;

    @Autowired
    private HandlerInvokeService handlerInvokeService;

    private boolean isSupported(MicroServiceType serviceType) {
        if ( MicroServiceType.simple_service.equals(serviceType) ) {
            // currently let the simple service pass for all request
            return true;
        }
        return serviceRegistry.getServiceType().equals(serviceType);
    }

    @Override
    public Object handleMessage(Object message) {
        if (message instanceof MicroServiceRequest) {
            MicroServiceRequest request = (MicroServiceRequest) message;
            if (isSupported(request.getServiceType())) {
                return handlerInvokeService.invoke(request.getAction(), request.getBody());
            }
        }
        throw new AmqpRejectAndDontRequeueException("Reject message" + message);
    }
}
