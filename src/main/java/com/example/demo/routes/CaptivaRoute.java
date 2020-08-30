package com.example.demo.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class CaptivaRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:captiva")
                .process(exchange -> {
                    CaptivaMessage body = exchange.getIn().getBody(CaptivaMessage.class);
                    System.out.println(body);
                }).end();



    }
}
