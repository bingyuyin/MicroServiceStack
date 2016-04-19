package com.suiyu.microservices.common;

import java.io.Serializable;

/**
 * Created by BingyuYin on 2016/4/16.
 */
public class MicroServiceResponse implements Serializable{
    private int responseCode;
    private String responseMessage;

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    @Override
    public String toString() {
        return "MicroServiceResponse [responseCode: " + responseCode +
                                        "responseMessage: " + responseMessage + "]";
    }
}
