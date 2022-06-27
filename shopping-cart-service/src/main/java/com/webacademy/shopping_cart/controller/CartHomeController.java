package com.webacademy.shopping_cart.controller;

import com.webacademy.common.entities.Course;
import com.webacademy.common.entities.Student;
import com.webacademy.shopping_cart.feign.CourseFeignClient;
import com.webacademy.shopping_cart.feign.StudentFeignClient;
import com.webacademy.shopping_cart.service.ShoppingCartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cart")
public class CartHomeController {

    @Autowired
    ShoppingCartServiceImpl shoppingCartService;
    @Autowired
    CourseFeignClient courseFeignClient;
    @Autowired
    StudentFeignClient studentFeignClient;

    @PostMapping("/addCourseToCart")
    public void addCourseToCart(Long courseId, Long studentId){
        Optional<Course> c = courseFeignClient.getCourseByCourseId(courseId);
        Optional<Student> s = studentFeignClient.getStudentById(studentId);
        shoppingCartService.addCourseToCart(c,s);
    }

}
