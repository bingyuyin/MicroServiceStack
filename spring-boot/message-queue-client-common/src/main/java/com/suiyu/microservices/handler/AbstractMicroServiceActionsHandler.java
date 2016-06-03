package com.suiyu.microservices.handler;


import com.suiyu.microservices.model.MicroServiceResponseFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by yinbing on 6/3/2016.
 */
abstract public class AbstractMicroServiceActionsHandler implements MicroServiceActionsHandler {

    protected class MethodInvokeHelper {
        private Object instance;
        private Method method;

        public MethodInvokeHelper(Object instance, Method method) {
            this.instance = instance;
            this.method = method;
        }

        public Object doInvoke(Object argBody) throws IllegalAccessException,
                                                InvocationTargetException{
            method.setAccessible(true);
            return method.invoke(instance, argBody);
        }

        public Object getInstance() {
            return instance;
        }

        public void setInstance(Object instance) {
            this.instance = instance;
        }

        public Method getMethod() {
            return method;
        }

        public void setMethod(Method method) {
            this.method = method;
        }
    }

    protected Map<String, MethodInvokeHelper> methodInvokeHelperMap = new ConcurrentHashMap<String, MethodInvokeHelper>();

    @Autowired
    private MicroServiceResponseFactory responseFactory;

    @Override
    public Object doHandle(String action, Object body) {
        if (!methodInvokeHelperMap.containsKey(action)) {
            return responseFactory.createNullActionHandleResponse(-1, "Can not handle action: " + action);
        }
        try {
           return methodInvokeHelperMap.get(action).doInvoke(body);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return responseFactory.createErrorResponse(-2, "Failed to handle action: " + action);
    }
}
