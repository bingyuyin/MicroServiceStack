package com.suiyu.microservices.model;

import com.suiyu.microservices.common.MicroServiceResponse;
import com.suiyu.microservices.common.NullActionHandleResponse;
import org.springframework.stereotype.Component;

/**
 * Created by BingyuYin on 2016/4/16.
 */
@Component
public class MicroServiceResponseFactory {

    public NullActionHandleResponse createNullActionHandleResponse(String message) {
        return createNullActionHandleResponse(-1, message);
    }

    public NullActionHandleResponse createNullActionHandleResponse(int code, String message) {
        NullActionHandleResponse response = new NullActionHandleResponse();
        response.setCode(code);
        response.setMessage(message);
        return response;
    }

    public MicroServiceResponse createErrorResponse(int code, String message) {
        MicroServiceResponse response = new MicroServiceResponse();
        response.setResponseCode(code);
        response.setResponseMessage(message);
        return response;
    }
}
