package com.suiyu.microservices.model;

import com.suiyu.microservices.common.MicroServiceRequest;
import com.suiyu.microservices.common.MicroServiceType;
import org.springframework.stereotype.Component;

/**
 * Created by BingyuYin on 2016/4/17.
 */
@Component
public class MicroServiceRequestFactory {

    public MicroServiceRequest createRequest(MicroServiceType serviceType, Object action) {
        return createRequest(serviceType, action, null);
    }

    public MicroServiceRequest createRequest(MicroServiceType serviceType, Object action, Object body) {
        MicroServiceRequest request = new MicroServiceRequest();
        request.setServiceType(serviceType);
        request.setAction(action);
        request.setBody(body);
        return request;
    }
}
