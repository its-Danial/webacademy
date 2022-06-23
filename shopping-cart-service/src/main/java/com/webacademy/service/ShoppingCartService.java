package com.webacademy.service;

import com.webacademy.common.entities.Course;

public interface ShoppingCartService {

    void addCourseToCart(Course course);

    void deleteCourseFromCart(Long courseId);
}
