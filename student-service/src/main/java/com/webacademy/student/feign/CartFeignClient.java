package com.webacademy.student.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name="shopping-cart-service", path = "/cart")
public interface CartFeignClient {

    @PostMapping("/create/{studentId}")
    ResponseEntity<String> createCart(@PathVariable("studentId") Long studentId);
}
