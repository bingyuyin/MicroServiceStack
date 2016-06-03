package com.suiyu.microservices.common;

import java.io.Serializable;

/**
 * Created by BingyuYin on 2016/4/15.
 */
public class MicroServiceRequest implements Serializable {
    private Object body = null;
    private String serviceName = null;
    private String action = null;
    private String replyToTopic = null;
    private String replyToRoutingKey = null;
    private String replyToBroadcast = null;

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    public String getReplyToTopic() {
        return replyToTopic;
    }

    public void setReplyToTopic(String replyToTopic) {
        this.replyToTopic = replyToTopic;
    }

    public String getReplyToRoutingKey() {
        return replyToRoutingKey;
    }

    public void setReplyToRoutingKey(String replyToRoutingKey) {
        this.replyToRoutingKey = replyToRoutingKey;
    }

    public String getReplyToBroadcast() {
        return replyToBroadcast;
    }

    public void setReplyToBroadcast(String replyToBroadcast) {
        this.replyToBroadcast = replyToBroadcast;
    }

    @Override
    public String toString() {
        return "MicroServiceRequest [ serviceName: " + serviceName + ",\n" +
                                "action: " + action + ",\n" +
                                "body: " + body + ",\n" +
                                "replyToExchange: " + replyToTopic + ",\n" +
                                "replyToRoutingKey: " + replyToRoutingKey + ",\n" +
                                "replyToBroadcast: " + replyToBroadcast + "]";
    }
}
