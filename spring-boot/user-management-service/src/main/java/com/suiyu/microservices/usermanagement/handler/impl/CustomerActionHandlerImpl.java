package com.suiyu.microservices.usermanagement.handler.impl;

import com.suiyu.microservices.common.type.CustomerActionType;
import com.suiyu.microservices.handler.MicroServiceActionHandler;
import com.suiyu.microservices.model.MicroServiceResponseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by BingyuYin on 2016/4/17.
 */
@Component("customerActionHandlerImpl")
public class CustomerActionHandlerImpl implements MicroServiceActionHandler {
    @Autowired
    private MicroServiceResponseFactory responseFactory;

    @Override
    public Object doHandle(Object action, Object body) {
        if (action instanceof CustomerActionType) {
            CustomerActionType actionType = (CustomerActionType)action;
            Object res = null;
            switch(actionType) {
                case get_all_customers:
                    res = "get all customers request handled!" + "\n" +
                    "handled body: " + body;
                    break;
            }
            return res;
        }
        return responseFactory.createNullActionHandleResponse(-1, "Can not handle the action: " + action);
    }
}
