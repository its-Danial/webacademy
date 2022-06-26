package com.webacademy.shopping_cart.controller;

import com.webacademy.shopping_cart.feign.HomeFeignClient;
import com.webacademy.shopping_cart.service.ShoppingCartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartHomeController {

    @Autowired
    ShoppingCartServiceImpl shoppingCartService;

    @Autowired
    HomeFeignClient homeFeignClient;

//    @PostMapping("/addCourseToCart")
//    public void addCourseToCart(Long courseId, Long studentId){
//        shoppingCartService.addCourseToCart(courseId, studentId);
//    }

    @GetMapping("/todos")
    public List<com.neusoft.Models.Todos> getAllTodos(){
        return homeFeignClient.getAllTodos();
    };
}
