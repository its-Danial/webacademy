package com.webacademy.shopping_cart.service;

import com.webacademy.common.entities.ShoppingCart;


public interface ShoppingCartService {

    void createCart(Long studentId);

    ShoppingCart findCartById(Long cartId);

    void addCourseToCart(Long cartId, Long courseId);

    void removeCourseFromCart(Long cartId, Long courseId);

    void buyAllCourseFromCart(Long studentId);
}
