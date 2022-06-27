package com.webacademy.shopping_cart.service;

import com.webacademy.common.repositories.CourseRepository;
import com.webacademy.common.repositories.ShoppingCartRepository;
import com.webacademy.common.repositories.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("shoppingCartService")
@Slf4j
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Autowired
    ShoppingCartRepository shoppingCartRepository;


//    @Override
//    public void addCourseToCart(Long courseId, Long studentId) {
//        shoppingCartRepository.addCourseToCart(courseId, studentId);
//        log.info("Added course {} to cart", courseId);
//    }

//    @Override
//    public void deleteCourseFromCart(Long courseId) {

//    }
}
