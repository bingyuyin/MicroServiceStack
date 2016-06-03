package com.suiyu.microservices.model;

import com.suiyu.microservices.common.MicroServiceRequest;
import org.springframework.stereotype.Component;

/**
 * Created by BingyuYin on 2016/4/17.
 */
@Component
public class MicroServiceRequestFactory {

    public MicroServiceRequest createMicroServiceRequest(String serviceName,
                                                         String action,
                                                         Object body,
                                                         String replyToTopic,
                                                         String replyToRoutingKey) {
        return createMicroServiceRequest(serviceName, action, body, replyToTopic, replyToRoutingKey, null);
    }

    public MicroServiceRequest createMicroServiceRequest(String serviceName,
                                                         String action,
                                                         Object body,
                                                         String replyToTopic,
                                                         String replyToRoutingKey,
                                                         String replyToBroadcast) {
        MicroServiceRequest request = new MicroServiceRequest();
        request.setServiceName(serviceName);
        request.setAction(action);
        request.setBody(body);
        request.setReplyToTopic(replyToTopic);
        request.setReplyToRoutingKey(replyToRoutingKey);
        request.setReplyToBroadcast(replyToBroadcast);
        return request;
    }

//    public MicroServiceRequest createRequest(String serviceType,
//                                             Object action,
//                                             Object body,
//                                             String replyToExchangeName,
//                                             String replyToRoutingKey) {
//        MicroServiceRequest request = new MicroServiceRequest();
//        request.setServiceType(serviceType);
//        request.setAction(action);
//        request.setBody(body);
//        request.setReplyToExchangeName(replyToExchangeName);
//        request.setReplyToRoutingKey(replyToRoutingKey);
//        return request;
//    }
//
//    public MicroServiceRequest createRequest(MicroServiceType serviceType, Object action) {
//        return createRequest(serviceType, action, null);
//    }
//
//    public MicroServiceRequest createRequest(MicroServiceType serviceType, Object action, Object body) {
//        return createRequest(serviceType, action, body, null, null);
//    }
}
