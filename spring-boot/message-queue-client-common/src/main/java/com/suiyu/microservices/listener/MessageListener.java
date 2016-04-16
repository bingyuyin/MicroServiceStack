package com.suiyu.microservices.listener;

import org.springframework.stereotype.Component;

/**
 * Created by BingyuYin on 2016/4/15.
 */
@Component
public interface MessageListener {
    Object handleMessage(Object message);
}
