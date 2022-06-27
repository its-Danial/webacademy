package com.webacademy.shopping_cart.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name="course-service", path = "/course")
public interface JSONFeign {

    @GetMapping("/hello")
    String hello();
}
