package com.webacademy.shopping_cart.service;

import com.webacademy.common.entities.Course;
import com.webacademy.common.entities.ShoppingCart;
import com.webacademy.common.entities.Student;

import java.util.List;
import java.util.Optional;


public interface ShoppingCartService {

    ShoppingCart findCartById(Long cartId);

    void addCourseToCart(Long cartId, Long courseId);

    void removeCourseFromCart(Long cartId, Long courseId);

    void buyAllCourseFromCart(Long studentId);
}
