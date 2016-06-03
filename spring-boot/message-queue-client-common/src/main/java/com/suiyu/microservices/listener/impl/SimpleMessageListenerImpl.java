package com.suiyu.microservices.listener.impl;

import com.suiyu.microservices.common.MicroServiceRequest;
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

    @Autowired
    private MicroServiceRegistry serviceRegistry;

    @Autowired
    private HandlerInvokeService handlerInvokeService;

    @PostConstruct
    public void initSimpleMessageListenerImpl() {

    }

    private boolean isSupported(String serviceName) {
        return (serviceRegistry.getServiceName() != null) && serviceRegistry.getServiceName().equals(serviceName);
    }

    private boolean rejectMessage(Object message) {
        return (message == null) ||
                !(message instanceof MicroServiceRequest) ||
                !isSupported(((MicroServiceRequest) message).getServiceName());

    }

    @Override
    @Deprecated
    public Object handleMessage(Object message) {
        if (rejectMessage(message)) {
            throw new AmqpRejectAndDontRequeueException("Reject message" + message);
        }
        return handlerInvokeService.doInvoke(((MicroServiceRequest) message).getAction(),
                ((MicroServiceRequest) message).getBody());
    }


    @Override
    public void doHandle(Object message) {
        if (rejectMessage(message)) {
            throw new AmqpRejectAndDontRequeueException("Reject message: " + message);
        }
        handlerInvokeService.invoke((MicroServiceRequest) message);

    }
}
