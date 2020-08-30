package com.example.demo.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ConfigRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        from("direct:config")
                .process(exchange -> {
                    ConfigMessage body = exchange.getIn().getBody(ConfigMessage.class);
                    System.out.println(body);
                })
                .process(exchange -> {
                    ConfigMessage body = exchange.getIn().getBody(ConfigMessage.class);
                     exchange.getIn().setBody(new CaptivaMessage(body.getValue()));
                    System.out.println(body);
                })
                .to("direct:captiva");

    }
}
