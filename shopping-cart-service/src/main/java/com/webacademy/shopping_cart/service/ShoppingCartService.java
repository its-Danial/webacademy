package com.webacademy.shopping_cart.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


public interface ShoppingCartService {

//    @PostMapping("/{courseId}")
//    void addCourseToCart(@PathVariable("courseId") Long courseId, Long studentId);

    void deleteCourseFromCart(Long courseId);
}
