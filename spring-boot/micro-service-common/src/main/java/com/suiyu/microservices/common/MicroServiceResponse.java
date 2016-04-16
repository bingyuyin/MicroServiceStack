package com.suiyu.microservices.common;

/**
 * Created by BingyuYin on 2016/4/16.
 */
public class MicroServiceResponse {
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
        return "MicroServiceResponse [ " + "\n" +
                                        "responseCode: " + responseCode + ",\n" +
                                        "responseMessage: " + responseMessage + "\n]";
    }
}
