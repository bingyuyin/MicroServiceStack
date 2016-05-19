package com.suiyu.microservices.common;

import java.io.Serializable;

/**
 * Created by BingyuYin on 2016/4/15.
 */
public class MicroServiceRequest implements Serializable {
    private Object body = null;
    private MicroServiceType serviceType = null;
    private Object action  = null;
    private String replyToExchange = null;
    private String replyToRoutingKey = null;

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    public MicroServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(MicroServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public Object getAction() {
        return action;
    }

    public void setAction(Object action) {
        this.action = action;
    }

    public String getReplyToExchange() {
        return replyToExchange;
    }

    public void setReplyToExchange(String replyToExchange) {
        this.replyToExchange = replyToExchange;
    }

    public String getReplyToRoutingKey() {
        return replyToRoutingKey;
    }

    public void setReplyToRoutingKey(String replyToRoutingKey) {
        this.replyToRoutingKey = replyToRoutingKey;
    }

    public String toString() {
        return "MicroServiceRequest [ serviceType: " + serviceType + ",\n" +
                                "action: " + action + ",\n" +
                                "body: " + body + ",\n" +
                                "replyToExchange: " + replyToExchange + ",\n" +
                                "replyToRoutingKey: " + replyToRoutingKey + "]";
    }
}
