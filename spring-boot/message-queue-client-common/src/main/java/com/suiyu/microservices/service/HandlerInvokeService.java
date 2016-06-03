package com.suiyu.microservices.service;

import com.suiyu.microservices.common.MicroServiceRequest;
import org.springframework.stereotype.Component;

/**
 * Created by BingyuYin on 2016/4/16.
 */
@Component
public interface HandlerInvokeService {
    Object doInvoke(String action, Object body);
    void invoke(MicroServiceRequest request);
}
