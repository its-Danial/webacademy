//package com.webacademy.gateway.config;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.cloud.gateway.filter.GatewayFilter;
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.GlobalFilter;
//import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
//import org.springframework.core.Ordered;
//import org.springframework.http.HttpHeaders;
//import org.springframework.stereotype.Component;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
//import java.util.Set;
//
//@Component
//@Slf4j
//public class LoginFilter implements GlobalFilter, Ordered {
//
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//
//
//        log.info("Pre-Filter executed");
//
//        String requestPath = exchange.getRequest().getPath().toString();
//        log.info("Request path = " + requestPath);
//
//        HttpHeaders headers = exchange.getRequest().getHeaders();
//        Set<String> headerNames = headers.keySet();
//
//        headerNames.forEach((header) -> {
//            log.info(header + " === " + headers.get(header));
//        });
//
//        log.info("Request = {}", exchange.getRequest().getHeaders());
//        log.info("Request = {}", exchange.getRequest().getSslInfo());
//        log.info("Request = {}", exchange.getRequest().getMethod());
//        log.info("Request = {}", exchange.getRequest().getMethodValue());
//        log.info("Response = {}", exchange.getResponse().getHeaders());
//        log.info("Response = {}", exchange.getResponse().getStatusCode());
//        log.info("Response = {}", exchange.getResponse());
//
//        return chain.filter(exchange);
//    }
//
//    @Override
//    public int getOrder() {
//        return 0;
//    }

//    public LoginFilter() {
//        super(Config.class);
//    }
//
//    @Override
//    public GatewayFilter apply(Config config) {
//        //Custom Pre Filter. Suppose we can extract JWT and perform Authentication
//        System.out.println("config = " + config);
//        return (exchange, chain) -> {
//            System.out.println("First pre filter " + exchange.getRequest().getMethod());
//            //Custom Post Filter.Suppose we can call error response handler based on error code.
//            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
//                System.out.println("First post filter " + chain.filter(exchange).toString());
//            }));
//        };
//    }
//
//    public static class Config {
//    }
//}
