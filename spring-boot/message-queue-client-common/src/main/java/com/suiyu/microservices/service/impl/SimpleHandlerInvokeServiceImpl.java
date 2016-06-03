package com.suiyu.microservices.service.impl;

import com.suiyu.microservices.handler.MicroServiceActionsHandler;
import com.suiyu.microservices.service.AbstractHandlerInvokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

/**
 * Created by BingyuYin on 2016/4/16.
 */
@Component
public class SimpleHandlerInvokeServiceImpl extends AbstractHandlerInvokeService {

    @Autowired
    @Qualifier(value = "genericActionRequestHandlerImpl")
    private MicroServiceActionsHandler genericActionRequestHandler;

    @Autowired
    @Qualifier(value = "commonActionRequestHandlerImpl")
    private MicroServiceActionsHandler commonActionRequestHandler;

    // post construct method can be override, so choose a different name
    @PostConstruct
    public void initSimpleHandlerInvokeService () {
        list.add(genericActionRequestHandler);
        list.add(commonActionRequestHandler);
    }


}
