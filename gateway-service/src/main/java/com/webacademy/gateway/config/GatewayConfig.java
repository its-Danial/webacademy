//package com.webacademy.gateway.config;
//
//import org.springframework.cloud.gateway.route.RouteLocator;
//import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class GatewayConfig {
//    @Bean
//    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route("student-service",
//                        r -> r.path("/student/**")
//                                .filters(f -> f.addRequestHeader("first-request", "first-request-header")
//                                        .addResponseHeader("first-response", "first-response-header"))
//                        .uri("http://localhost:8081"))
//                .route("teacher-service",
//                        r -> r.path("/teacher/**")
//                                .uri("http://localhost:8082"))
//                .route("course-service",
//                        r -> r.path("/course/**")
//                                .uri("http://localhost:8083"))
//                .route("course-lecture-service",
//                        r -> r.path("/lecture/**")
//                                .uri("http://localhost:8084"))
//                .route("shopping-cart-service",
//                        r -> r.path("/cart/**")
//                                .uri("http://localhost:8085"))
//                .route("student-progress-service",
//                        r -> r.path("/progress/**")
//                                .uri("http://localhost:8086"))
//                .build();
//    }
//}