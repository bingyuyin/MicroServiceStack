package com.suiyu.microservices.gateway.controller.impl;

import com.suiyu.microservices.common.MicroServiceConstants;
import com.suiyu.microservices.common.MicroServiceRequest;
import com.suiyu.microservices.common.type.CustomerActionType;
import com.suiyu.microservices.common.type.MicroServiceType;
import com.suiyu.microservices.gateway.controller.CustomerController;
import com.suiyu.microservices.model.MQAdmin;
import com.suiyu.microservices.model.MQCommunicationTemplate;
import com.suiyu.microservices.model.MicroServiceRequestFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

/**
 * Created by yinbing on 5/20/2016.
 */
@Controller
@RequestMapping("/customer")
public class CustomerControllerImpl implements CustomerController {

    @Autowired
    private MQCommunicationTemplate mqCommunicationTemplate;

    @Autowired
    private MQAdmin mqAdmin;

    @Autowired
    private MicroServiceRequestFactory requestFactory;

    @Override
    @RequestMapping(value = "all", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Object> getCustomers() {
        String callerId = UUID.randomUUID().toString();
        String queueName = "get-all-customers-" + callerId;


        MicroServiceRequest request = requestFactory.createRequest(MicroServiceType.user_management_service,
                CustomerActionType.get_all_cutomers,
                null, "", "");

        mqCommunicationTemplate.sendAndReceive(request,
                MicroServiceConstants.REQUEST_EXCHANGE_NAME,
                MicroServiceConstants.USER_MANAGEMENT_SERVICE_QUEUE_NAME,
                "");
        return null;
    }
}
