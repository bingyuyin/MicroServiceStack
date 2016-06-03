package com.suiyu.microservices.gateway.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by yinbing on 5/20/2016.
 */
@Controller
@RequestMapping("/test")
public interface TestController {
    @RequestMapping(value="all",method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<Object> getTest();

}
