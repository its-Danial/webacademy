package com.webacademy.shopping_cart.controller;

import com.webacademy.shopping_cart.feign.CourseFeignClient;
import com.webacademy.shopping_cart.service.ShoppingCartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartHomeController {

    @Autowired
    ShoppingCartServiceImpl shoppingCartService;


    @Autowired
    CourseFeignClient courseFeignClient;

    @PostMapping("/addCourseToCart")
    public void addCourseToCart(Long courseId, Long studentId){
        courseFeignClient.getCourseByCourseId(courseId);
    }





}
