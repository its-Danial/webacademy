package com.webacademy.shopping_cart.service;

import com.webacademy.common.entities.Course;
import com.webacademy.common.entities.ShoppingCart;
import com.webacademy.common.entities.Student;

import java.util.List;
import java.util.Optional;


public interface ShoppingCartService {


//    void addCourseToCart(Long courseId, Long studentId);

//    List<Object> findShoppingCarts(Long courseId, Long studentId);

    void removeCourseFromCart(Long courseId);
}
