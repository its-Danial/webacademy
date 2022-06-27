package com.webacademy.shopping_cart.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="course-service", path = "/course")
public interface CartFeignClient {

    @GetMapping("/hello")
    String hello();
}
