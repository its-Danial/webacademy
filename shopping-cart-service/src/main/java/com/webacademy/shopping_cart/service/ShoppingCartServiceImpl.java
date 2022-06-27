package com.webacademy.shopping_cart.service;

import com.webacademy.common.entities.Course;
import com.webacademy.common.entities.Student;
import com.webacademy.shopping_cart.repository.ShoppingCartRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service("shoppingCartService")
@Slf4j
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Autowired
    ShoppingCartRepository shoppingCartRepository;


    @Override
    public void addCourseToCart(Optional<Course> course, Optional<Student> student) {
        shoppingCartRepository.addCourseToCart(course, student);
        log.info("Added course {} to cart", course);
    }

//    @Override
//    public void deleteCourseFromCart(Long courseId) {

//    }
}
