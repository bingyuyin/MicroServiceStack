package com.suiyu.microservices.testservice.handler.impl;

import com.suiyu.microservices.handler.AbstractMicroServiceActionsHandler;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by yinbing on 6/3/2016.
 */
@Component(value = "testActionsHandlerImpl")
public class TestActionsHandlerImpl extends AbstractMicroServiceActionsHandler {

    @PostConstruct
    public void initTestActionsHandler() {
        handlerLookup.put("test_action", new ActionHandler() {
            @Override
            public Object doHandle(Object body) {
                return test(body);
            }
        });
    }

    private String test(Object body) {
        return "Test Action Handler Test: " + body;
    }
}
