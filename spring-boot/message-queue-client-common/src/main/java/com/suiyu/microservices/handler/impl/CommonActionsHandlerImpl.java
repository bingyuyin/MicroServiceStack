package com.suiyu.microservices.handler.impl;

import com.suiyu.microservices.handler.AbstractMicroServiceActionsHandler;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by BingyuYin on 2016/4/16.
 */
@Component("commonActionRequestHandlerImpl")
public class CommonActionsHandlerImpl extends AbstractMicroServiceActionsHandler {
    @PostConstruct
    public void initGenericActionsHandler() {
        handlerLookup.put("common_test_action", new ActionHandler() {
            @Override
            public Object doHandle(Object body) {
                return test(body);
            }
        });
    }

    private String test(Object body) {
        return "Common Action Handler Test" + body;
    }

}
