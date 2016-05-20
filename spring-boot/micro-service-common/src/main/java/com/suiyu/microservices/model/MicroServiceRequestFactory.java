package com.suiyu.microservices.model;

import com.suiyu.microservices.common.MicroServiceRequest;
import com.suiyu.microservices.common.type.MicroServiceType;
import org.springframework.stereotype.Component;

/**
 * Created by BingyuYin on 2016/4/17.
 */
@Component
public class MicroServiceRequestFactory {

    public MicroServiceRequest createRequest(MicroServiceType serviceType,
                                             Object action,
                                             Object body,
                                             String replyToExchangeName,
                                             String replyToRoutingKey) {
        MicroServiceRequest request = new MicroServiceRequest();
        request.setServiceType(serviceType);
        request.setAction(action);
        request.setBody(body);
        request.setReplyToExchangeName(replyToExchangeName);
        request.setReplyToRoutingKey(replyToRoutingKey);
        return request;
    }

    public MicroServiceRequest createRequest(MicroServiceType serviceType, Object action) {
        return createRequest(serviceType, action, null);
    }

    public MicroServiceRequest createRequest(MicroServiceType serviceType, Object action, Object body) {
        return createRequest(serviceType, action, body, null, null);
    }
}
