package com.suiyu.microservices.model;

import com.suiyu.microservices.common.MicroServiceResponse;
import org.springframework.stereotype.Component;

/**
 * Created by BingyuYin on 2016/4/16.
 */
@Component
public class MicroServiceResponseFactory {
    public MicroServiceResponse createErrorResponse(int code, String message) {
        MicroServiceResponse response = new MicroServiceResponse();
        response.setResponseCode(code);
        response.setResponseMessage(message);
        return response;
    }
}
