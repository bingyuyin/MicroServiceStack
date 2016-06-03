package com.suiyu.microservices.handler;

/**
 * Created by BingyuYin on 2016/4/15.
 */
public interface MicroServiceActionsHandler {
    Object doHandle(String action, Object body);
}
