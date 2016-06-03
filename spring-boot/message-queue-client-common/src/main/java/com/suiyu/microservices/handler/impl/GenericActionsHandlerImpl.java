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
    void initGenericActionsHandler() {
        try {
            methodInvokeHelperMap.put("generic_test",
                    new MethodInvokeHelper(this, this.getClass().getDeclaredMethod("test", Object.class)));
        } catch (NoSuchMethodException ex) {
            ex.printStackTrace();
        }
    }

    private String test(Object body) {
        return "Generic Action Handler Test" + body;
    }
}
