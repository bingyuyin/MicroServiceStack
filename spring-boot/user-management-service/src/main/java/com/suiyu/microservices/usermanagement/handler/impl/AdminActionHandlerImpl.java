package com.suiyu.microservices.usermanagement.handler.impl;

import com.suiyu.microservices.handler.MicroServiceActionHandler;
import com.suiyu.microservices.model.MicroServiceResponseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by BingyuYin on 2016/4/17.
 */
@Component("adminActionHandlerImpl")
public class AdminActionHandlerImpl implements MicroServiceActionHandler {
    @Autowired
    private MicroServiceResponseFactory responseFactory;

    @Override
    public Object doHandle(Object action, Object body) {
        return responseFactory.createNullActionHandleResponse(-1, "Can not handle the action: " + action);
    }
}
