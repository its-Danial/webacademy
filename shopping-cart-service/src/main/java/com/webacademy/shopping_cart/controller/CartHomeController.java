package com.webacademy.shopping_cart.controller;

import com.webacademy.shopping_cart.feign.JSONFeign;
import com.webacademy.shopping_cart.feign.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    JSONFeign jsonFeign;

    @GetMapping("/myposts")
    public List<Post> getAllPosts(){
      return jsonFeign.getAllPosts();
    };



}
