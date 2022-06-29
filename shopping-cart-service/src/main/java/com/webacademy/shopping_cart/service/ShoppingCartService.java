package com.webacademy.shopping_cart.service;

import com.webacademy.common.entities.Course;
import com.webacademy.common.entities.ShoppingCart;
import com.webacademy.common.entities.Student;

import java.util.Optional;


public interface ShoppingCartService {


//    void addCourseToCart(Long courseId, Long studentId, ShoppingCart cart);

    void removeCourseFromCart(Long courseId);
}
