package com.webacademy.shopping_cart.service;

import com.webacademy.common.entities.Course;
import com.webacademy.common.entities.ShoppingCart;
import com.webacademy.common.entities.Student;
import com.webacademy.shopping_cart.feign.CourseFeignClient;
import com.webacademy.shopping_cart.feign.StudentFeignClient;
import com.webacademy.shopping_cart.repository.ShoppingCartRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service("shoppingCartService")
@Slf4j
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Autowired
    ShoppingCartRepository shoppingCartRepository;
    @Autowired
    CourseFeignClient courseFeignClient;
    @Autowired
    StudentFeignClient studentFeignClient;
//    @Override
//    public void addCourseToCart(Long courseId, Long studentId) {
//        Student s = studentFeignClient.getStudentById(studentId).orElse(null);
//        Course c = courseFeignClient.getCourseByCourseId(courseId).orElse(null);
//        List<Course> courses = new ArrayList<>();
//        courses.add(c);
//        ShoppingCart cart = null;
//
//        shoppingCartRepository.save(cart.setCourse(courses));
//
//        log.info("Added course {} to student {} cart", c.getTitle(), s.getUsername());
//    }

    @Override
    public void removeCourseFromCart(Long courseId) {
        shoppingCartRepository.deleteById(courseId);
        log.info("Removed course no:{} to cart", courseId);
    }
}
