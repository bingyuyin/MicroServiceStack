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
        try {
            methodInvokeHelperMap.put("test_action",
                    new MethodInvokeHelper(this, this.getClass().getDeclaredMethod("test", Object.class)));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private String test(Object body) {
        return "Test Service Test" + body;
    }
}
