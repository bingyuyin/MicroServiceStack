package com.suiyu.microservices.handler.impl;

import com.suiyu.microservices.common.GenericActionType;
import com.suiyu.microservices.common.MicroServiceResponse;
import com.suiyu.microservices.handler.MicroServiceRequestHandler;
import com.suiyu.microservices.model.MicroServiceResponseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by BingyuYin on 2016/4/15.
 */
@Component("genericActionRequestHandlerImpl")
public class GenericActionRequestHandlerImpl implements MicroServiceRequestHandler{
    @Autowired
    private MicroServiceResponseFactory responseFactory;
    @Override
    public Object doHandle(Object action, Object body) {
        if ( action instanceof GenericActionType ) {
            GenericActionType actionType = (GenericActionType) action;
            Object response = null;
            switch (actionType) {
                case generic_action_test1:
                    response = "Handled action: " + action + ", body: " + body;
                    break;
                case generic_action_test2:
                    response = "Handled action: " + action + ", body: " + body;
                    break;
            }
            return response;
        }
        return responseFactory.createErrorResponse(-1, "Can not handle action: " + action);
    }
}
