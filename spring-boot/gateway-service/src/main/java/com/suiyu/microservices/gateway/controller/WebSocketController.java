package com.suiyu.microservices.gateway.controller;

import com.suiyu.microservices.gateway.utils.CacheUtils;
import org.atmosphere.config.service.DeliverTo;
import org.atmosphere.config.service.Disconnect;
import org.atmosphere.config.service.ManagedService;
import org.atmosphere.config.service.Ready;
import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.AtmosphereResourceEvent;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by BingyuYin on 2016/4/16.
 */
@ManagedService(path = "/ws")
public class WebSocketController {
    /**
     * can not autowired spring beans
     */
    private RabbitTemplate rabbitTemplate = CacheUtils.rabbitTemplate;

    @Ready
    @DeliverTo(DeliverTo.DELIVER_TO.RESOURCE)
    public void onReady(final AtmosphereResource resource) {
        resource.getResponse().write("Client " + resource.uuid() + " is ready.");
    }

    @Disconnect
    public void onDisconnect(AtmosphereResourceEvent event) {
    }

    @org.atmosphere.config.service.Message
    @DeliverTo(DeliverTo.DELIVER_TO.RESOURCE)
    public String onMessage(AtmosphereResource resource, Reader reader) throws IOException {
        System.out.println("onMessage invoked " + resource.uuid());
        return "Handled message from: " + resource.uuid();
    }
}
