package com.suiyu.microservices.testservice.service.impl;

import com.suiyu.microservices.handler.MicroServiceActionsHandler;
import com.suiyu.microservices.service.impl.SimpleHandlerInvokeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created by yinbing on 6/3/2016.
 */
@Service
@Primary
public class TestServiceHandlerInvokerServiceImpl extends SimpleHandlerInvokeServiceImpl{

    @Autowired
    @Qualifier(value = "testActionsHandlerImpl")
    private MicroServiceActionsHandler testActionsHandler;

    @PostConstruct
    public void initTestServiceHandlerInvokerService() {
        list.add(testActionsHandler);
    }

}
