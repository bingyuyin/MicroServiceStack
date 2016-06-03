package com.suiyu.microservices.handler.impl;

import com.suiyu.microservices.handler.AbstractMicroServiceActionsHandler;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by BingyuYin on 2016/4/15.
 */
@Component("genericActionRequestHandlerImpl")
public class GenericActionsHandlerImpl extends AbstractMicroServiceActionsHandler {

    @PostConstruct
    public void initGenericActionsHandler() {
        handlerLookup.put("generic_test_action", new ActionHandler() {
            @Override
            public Object doHandle(Object body) {
                return test(body);
            }
        });
    }

    private String test(Object body) {
        return "Generic Action Handler Test: " + body;
    }
}
