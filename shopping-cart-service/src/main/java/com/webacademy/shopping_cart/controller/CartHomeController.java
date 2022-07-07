package com.webacademy.shopping_cart.controller;

import com.webacademy.common.entities.Course;
import com.webacademy.common.entities.Student;
import com.webacademy.shopping_cart.feign.CourseFeignClient;
import com.webacademy.shopping_cart.feign.StudentFeignClient;
import com.webacademy.shopping_cart.repository.ShoppingCartRepository;
import com.webacademy.shopping_cart.service.ShoppingCartServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @Autowired
    ShoppingCartRepository shoppingCartRepository;

    // Shows which student is accessing the cart.
    // e.g. /cart/123
    //TODO: Make sure if this cart thing is needed
    @GetMapping("/{studentId}")
    @ResponseStatus(HttpStatus.OK)
    public void getStudentId(@PathVariable("studentId") Long id){
        studentFeignClient.getStudentById(id);
        log.info("Current cart is student {}", id);
    }

    @PostMapping("/add/{cartId}/{courseId}")
    public ResponseEntity<String> addCourseToCart(@PathVariable("cartId") Long cartId,
                                                  @PathVariable("courseId") Long courseId){
            shoppingCartService.addCourseToCart(cartId, courseId);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Student " + cartId + " has successfully added course "
                            + courseId + " to cart");
    }

    @DeleteMapping("/delete/{cartId}/{courseId}")
    public ResponseEntity<String> removeCourseFromCart(@PathVariable("cartId") Long cartId,
                                                       @PathVariable("courseId") Long courseId){
        shoppingCartService.removeCourseFromCart(cartId, courseId);
        return ResponseEntity.status(HttpStatus.OK)
                .body("Student " + cartId + " has successfully removed course "
                        + courseId + " from cart");
    }

    @PostMapping("/buy-all/{studentId}")
    public ResponseEntity<String> buyCourseFromCart(@PathVariable("studentId")Long studentId){
        shoppingCartService.buyAllCourseFromCart(studentId);

        return ResponseEntity.status(HttpStatus.OK)
                .body("Student " + studentId + " has successfully bought all courses from cart");
    }

}
