package com.suiyu.microservices.handler.impl;

import com.suiyu.microservices.common.type.CommonActionType;
import com.suiyu.microservices.handler.MicroServiceActionHandler;
import com.suiyu.microservices.model.MicroServiceResponseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by BingyuYin on 2016/4/16.
 */
@Component("commonActionRequestHandlerImpl")
public class CommonActionHandlerImpl implements MicroServiceActionHandler {
    @Autowired
    private MicroServiceResponseFactory responseFactory;

    @Override
    public Object doHandle(Object action, Object body) {
        if ( action instanceof CommonActionType) {
            CommonActionType actionType = (CommonActionType) action;
            Object response = null;
            switch (actionType) {
                case common_action_test1:
                    response = "handled action: " + action;
                    break;
                case common_action_test2:
                    response = "handled action: " + action;
                    break;
            }
            return response;
        }
        return responseFactory.createNullActionHandleResponse(-1, "Can not handle action: " + action);
    }
}
