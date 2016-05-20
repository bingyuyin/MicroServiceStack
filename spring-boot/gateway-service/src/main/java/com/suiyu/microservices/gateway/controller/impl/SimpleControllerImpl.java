package com.suiyu.microservices.gateway.controller.impl;

import com.suiyu.microservices.common.*;
import com.suiyu.microservices.common.type.CommonActionType;
import com.suiyu.microservices.common.type.GenericActionType;
import com.suiyu.microservices.common.type.MicroServiceType;
import com.suiyu.microservices.model.MQCommunicationTemplate;
import com.suiyu.microservices.model.MicroServiceRequestFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by BingyuYin on 2016/4/16.
 */
@Controller
@RequestMapping("/simple")
public class SimpleControllerImpl {

    @Autowired
    private MicroServiceRequestFactory requestFactory;

    @Autowired
    private MQCommunicationTemplate mqCommunicationTemplate;

    @RequestMapping(value = "genericTest1", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Object> genericTest1() {
        MicroServiceRequest request = requestFactory.createRequest(MicroServiceType.simple_service, GenericActionType.generic_action_test1);
        System.out.println("Sending request: " + request);
        return mqCommunicationTemplate.sendAndReceiveResponseEntity(request,
                                        MicroServiceConstants.GATEWAY_TOPIC_EXCHANGE_NAME,
                                        MicroServiceConstants.SIMPLE_SERVICE_QUEUE_NAME);
    }

    @RequestMapping(value = "genericTest2", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Object> genericTest2() {
        MicroServiceRequest request = requestFactory.createRequest(MicroServiceType.simple_service, GenericActionType.generic_action_test2);
        return mqCommunicationTemplate.sendAndReceiveResponseEntity(request,
                MicroServiceConstants.GATEWAY_TOPIC_EXCHANGE_NAME,
                MicroServiceConstants.SIMPLE_SERVICE_QUEUE_NAME);
    }

    @RequestMapping(value = "commonTest1", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Object> commonTest1() {
        MicroServiceRequest request = requestFactory.createRequest(MicroServiceType.simple_service, CommonActionType.common_action_test1);
        return mqCommunicationTemplate.sendAndReceiveResponseEntity(request,
                MicroServiceConstants.GATEWAY_TOPIC_EXCHANGE_NAME,
                MicroServiceConstants.SIMPLE_SERVICE_QUEUE_NAME);
    }

    @RequestMapping(value = "commonTest2", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Object> commonTest2() {
        MicroServiceRequest request = requestFactory.createRequest(MicroServiceType.simple_service, CommonActionType.common_action_test2);
        return mqCommunicationTemplate.sendAndReceiveResponseEntity(request,
                MicroServiceConstants.GATEWAY_TOPIC_EXCHANGE_NAME,
                MicroServiceConstants.SIMPLE_SERVICE_QUEUE_NAME);
    }
}
