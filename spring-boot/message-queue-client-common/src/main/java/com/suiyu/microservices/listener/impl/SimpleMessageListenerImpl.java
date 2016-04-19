package com.suiyu.microservices.listener.impl;

import com.suiyu.microservices.common.MicroServiceRequest;
import com.suiyu.microservices.common.MicroServiceType;
import com.suiyu.microservices.listener.MessageListener;
import com.suiyu.microservices.model.MicroServiceRegistry;
import com.suiyu.microservices.service.HandlerInvokeService;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by BingyuYin on 2016/4/15.
 */
@Component
public class SimpleMessageListenerImpl implements MessageListener {

    private Set<MicroServiceType> supportServiceSet = new HashSet<MicroServiceType>();

    @Autowired
    private MicroServiceRegistry serviceRegistry;

    @Autowired
    private HandlerInvokeService handlerInvokeService;

    @PostConstruct
    public void initSimpleMessageListenerImpl() {
        supportServiceSet.add(serviceRegistry.getServiceType());
        supportServiceSet.add(MicroServiceType.simple_service);
    }

    private boolean isSupported(MicroServiceType serviceType) {
        for ( MicroServiceType supportService : supportServiceSet ) {
            if ( supportService.equals(serviceType) ) {
                return true;
            }
        }
        return false;
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
