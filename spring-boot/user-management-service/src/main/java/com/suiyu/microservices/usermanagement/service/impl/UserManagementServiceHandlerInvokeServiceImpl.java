package com.suiyu.microservices.usermanagement.service.impl;

import com.suiyu.microservices.handler.MicroServiceActionsHandler;
import com.suiyu.microservices.service.impl.SimpleHandlerInvokeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by BingyuYin on 2016/4/17.
 */
@Component
@Primary
public class UserManagementServiceHandlerInvokeServiceImpl extends SimpleHandlerInvokeServiceImpl{
    @Autowired
    @Qualifier(value = "customerActionHandlerImpl")
    private MicroServiceActionsHandler customerActionHandlerImpl;

    @Autowired
    @Qualifier(value = "adminActionHandlerImpl")
    private MicroServiceActionsHandler adminActionHandlerImpl;

    @PostConstruct
    public void initUserManagement() {
        list.add(customerActionHandlerImpl);
        list.add(adminActionHandlerImpl);
    }

}
