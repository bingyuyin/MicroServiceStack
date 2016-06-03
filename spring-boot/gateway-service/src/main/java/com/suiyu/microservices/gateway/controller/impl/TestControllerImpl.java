package com.suiyu.microservices.gateway.controller.impl;

import com.suiyu.microservices.common.MicroServiceRequest;
import com.suiyu.microservices.gateway.controller.TestController;
import com.suiyu.microservices.model.MQAdmin;
import com.suiyu.microservices.model.MQCommunicationTemplate;
import com.suiyu.microservices.model.MicroServiceRequestFactory;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by yinbing on 5/20/2016.
 */
@Controller
@RequestMapping("/test")
public class TestControllerImpl implements TestController {

    @Autowired
    private MQCommunicationTemplate mqCommunicationTemplate;

    @Autowired
    private MQAdmin mqAdmin;

    @Autowired
    private MicroServiceRequestFactory requestFactory;

    @Autowired
    @Qualifier(value = "replyExchange")
    private TopicExchange replyExchange;

    @Autowired
    @Qualifier(value = "requestExchange")
    private TopicExchange requestExchange;

    @Override
    @RequestMapping(value = "all", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Object> getTest() {
        String receiveQueueName = mqAdmin.createTempQueueAndBindingExchangeWithName(replyExchange, "TEST-GET");
        MicroServiceRequest request = requestFactory.createMicroServiceRequest("TEST-SERVICE",
                "test_action",
                null,
                replyExchange.getName(),
                receiveQueueName);
        Object res = mqCommunicationTemplate.sendAndReceive(request, requestExchange.getName(), "TEST-SERVICE-QUEUE",receiveQueueName);
        return new ResponseEntity<Object>(res, HttpStatus.OK);
    }
}
