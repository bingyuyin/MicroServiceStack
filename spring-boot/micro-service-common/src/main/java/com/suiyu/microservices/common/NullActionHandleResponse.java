package com.suiyu.microservices.common;

import java.io.Serializable;

/**
 * Created by yinbing on 4/19/2016.
 */
public class NullActionHandleResponse implements Serializable {
    private int code = -1;
    private String message = "CAN NOT HANDLE THE ACTION";

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String toString () {
        return "NullActionHandleResponse : [ code: " + code +", message: " + message + "]";
    }
}
