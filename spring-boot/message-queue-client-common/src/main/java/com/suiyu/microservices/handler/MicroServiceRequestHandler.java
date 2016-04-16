package com.suiyu.microservices.handler;

/**
 * Created by BingyuYin on 2016/4/15.
 */
public interface MicroServiceRequestHandler {
    Object doHandle(Object action, Object body);
}
