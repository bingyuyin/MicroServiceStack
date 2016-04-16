package com.suiyu.microservices.service;

import com.suiyu.microservices.common.MicroServiceResponse;
import com.suiyu.microservices.handler.MicroServiceRequestHandler;
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
    protected List<MicroServiceRequestHandler> list = new ArrayList<MicroServiceRequestHandler>();

    @Autowired
    protected MicroServiceResponseFactory responseFactory;

    @Override
    public Object invoke(Object action, Object body) {
        for (MicroServiceRequestHandler handler : list) {
            Object response = handler.doHandle(action, body);
            if (response instanceof MicroServiceResponse) {
                if ( ((MicroServiceResponse) response).getResponseCode() == -1) {
                    continue;
                }
            }
            return response;
        }
        return responseFactory.createErrorResponse(-1, "Can not handle the action: " + action);
    }
}
