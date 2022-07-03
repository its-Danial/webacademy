package com.webacademy.shopping_cart.controller;

import com.webacademy.common.entities.Course;
import com.webacademy.common.entities.ShoppingCart;
import com.webacademy.common.entities.Student;
import com.webacademy.shopping_cart.feign.CourseFeignClient;
import com.webacademy.shopping_cart.feign.StudentFeignClient;
import com.webacademy.shopping_cart.service.ShoppingCartServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cart")
@Slf4j
public class CartHomeController {

    @Autowired
    ShoppingCartServiceImpl shoppingCartService;

    @Autowired
    CourseFeignClient courseFeignClient;
    @Autowired
    StudentFeignClient studentFeignClient;

    // Shows which student is accessing the cart.
    // e.g. /cart/123123
    @GetMapping("/{studentId}")
    @ResponseStatus(HttpStatus.OK)
    public void getStudentId(@PathVariable("studentId") Long id){
        studentFeignClient.getStudentById(id);
        log.info("Current cart is student {}", id);
    }

    @PostMapping("/add/{cartId}/{courseId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCourseToCart(@PathVariable("cartId") Long cartId,
                                @PathVariable("courseId") Long courseId){
        shoppingCartService.addCourseToCart(cartId, courseId);
    }

    @DeleteMapping("/delete/{cartId}/{courseId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeCourseFromCart(@PathVariable("cartId") Long cartId,
                                     @PathVariable("courseId") Long courseId){
        shoppingCartService.removeCourseFromCart(cartId, courseId);
    }

    @PostMapping("/buy/{studentId}/{courseId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void buyCourseFromCart(@PathVariable("studentId")Long studentId,
                                  @PathVariable("courseId") Long courseId){
        shoppingCartService.buyCourseFromCart(studentId, courseId);
    }

}
