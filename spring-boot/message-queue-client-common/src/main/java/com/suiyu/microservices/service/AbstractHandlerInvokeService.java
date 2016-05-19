package com.suiyu.microservices.service;

import com.suiyu.microservices.common.MicroServiceResponse;
import com.suiyu.microservices.common.NullActionHandleResponse;
import com.suiyu.microservices.handler.MicroServiceActionHandler;
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
    protected List<MicroServiceActionHandler> list = new ArrayList<MicroServiceActionHandler>();

    @Autowired
    protected MicroServiceResponseFactory responseFactory;

    @Autowired
    private MQCommunicationTemplate mqCommunicationTemplate;

    @Override
    public Object invoke(Object action, Object body) {
        for (MicroServiceActionHandler handler : list) {
            Object response = handler.doHandle(action, body);
            if (response instanceof NullActionHandleResponse) {
                continue;
            }
            return response;
        }
        return responseFactory.createNullActionHandleResponse(-1, "Can not handle the action: " + action);
    }

    @Override
    public void doInvoke(Object action, Object body, String replyToExchange, String replyToRoutingKey) {
        Object response = invoke(action, body);
        mqCommunicationTemplate.send(response, replyToExchange, replyToRoutingKey);
    }
}
