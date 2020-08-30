package com.example.demo.controllers;

import com.example.demo.routes.ConfigMessage;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.support.DefaultExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/message")
public class DemoController {

    @Autowired
    private ProducerTemplate producerTemplate;

    @Autowired
    CamelContext camelContext;

    @PostMapping
    public ConfigMessage message(@RequestBody ConfigMessage configMessage){
        producerTemplate.send("direct:config", createExchangeWithBody(camelContext , configMessage ));
        return configMessage;
    }

    protected Exchange createExchangeWithBody(CamelContext camelContext, Object body) {
        Exchange exchange = new DefaultExchange(camelContext);
        Message demoMessage = exchange.getIn();
        demoMessage.setBody(body);
        return exchange;
    }


}
