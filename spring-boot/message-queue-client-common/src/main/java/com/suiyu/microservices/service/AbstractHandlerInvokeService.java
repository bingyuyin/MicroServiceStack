package com.suiyu.microservices.service;

import com.suiyu.microservices.common.MicroServiceRequest;
import com.suiyu.microservices.common.NullActionHandleResponse;
import com.suiyu.microservices.handler.MicroServiceActionsHandler;
import com.suiyu.microservices.model.MQCommunicationTemplate;
import com.suiyu.microservices.model.MicroServiceResponseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BingyuYin on 2016/4/17.
 */
@Component
public class AbstractHandlerInvokeService implements HandlerInvokeService {
    protected List<MicroServiceActionsHandler> list = new ArrayList<MicroServiceActionsHandler>();

    @Autowired
    protected MicroServiceResponseFactory responseFactory;

    @Autowired
    private MQCommunicationTemplate mqCommunicationTemplate;

    @Override
    public Object doInvoke(String action, Object body) {
        for (MicroServiceActionsHandler handler : list) {
            Object response = handler.doHandle(action, body);
            if (response instanceof NullActionHandleResponse) {
                continue;
            }
            return response;
        }
        return responseFactory.createNullActionHandleResponse(-3, "Can not handle the action: " + action);
    }

    @Override
    public void invoke(MicroServiceRequest request) {
        Object response = doInvoke(request.getAction(), request.getBody());

        if (request.getReplyToTopic() != null &&
            !request.getReplyToTopic().equals("") &&
            request.getReplyToRoutingKey() != null &&
            !request.getReplyToRoutingKey().equals("")) {

            mqCommunicationTemplate.send(response,
                    request.getReplyToTopic(),
                    request.getReplyToRoutingKey());
        }
    }
}
