package com.suiyu.microservices.service;

import org.springframework.stereotype.Component;

/**
 * Created by BingyuYin on 2016/4/16.
 */
@Component
public interface HandlerInvokeService {
    Object invoke(Object action, Object body);
    void doInvoke(Object action, Object body, String replyToExchange, String replyToRoutingKey);
}
