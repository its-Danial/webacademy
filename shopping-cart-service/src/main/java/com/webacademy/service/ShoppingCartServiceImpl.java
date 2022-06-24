package com.webacademy.service;

import com.webacademy.common.entities.Course;
import com.webacademy.common.entities.ShoppingCart;
import com.webacademy.common.repositories.CourseRepository;
import com.webacademy.common.repositories.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;


public class ShoppingCartServiceImpl implements ShoppingCartService{
    @Autowired
    ShoppingCartRepository shoppingCartRepository;

    @Override
    public void addCourseToCart(Course course) {

    }

    @Override
    public void deleteCourseFromCart(Long courseId) {

    }
}
