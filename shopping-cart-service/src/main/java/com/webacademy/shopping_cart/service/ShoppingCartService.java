package com.webacademy.shopping_cart.service;

import com.webacademy.common.entities.Course;
import com.webacademy.common.entities.Student;

import java.util.Optional;


public interface ShoppingCartService {


    void addCourseToCart(Optional<Course> course, Optional<Student> student);

//    void deleteCourseFromCart(Long courseId);
}
