package com.webacademy.shopping_cart.controller;

import com.webacademy.shopping_cart.feign.CartFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartHomeController {
//
//    @Autowired
//    ShoppingCartServiceImpl shoppingCartService;
//
//    @PostMapping("/addCourseToCart")
//    public void addCourseToCart(Long courseId, Long studentId){
//        shoppingCartService.addCourseToCart(courseId, studentId);
//    }

    @Autowired
    CartFeignClient cartFeignClient;

    @GetMapping("/all")
    public String getAll(){
      return cartFeignClient.hello();
    };



}
