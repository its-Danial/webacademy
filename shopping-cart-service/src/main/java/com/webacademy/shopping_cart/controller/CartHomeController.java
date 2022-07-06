package com.webacademy.shopping_cart.controller;

import com.webacademy.shopping_cart.feign.CourseFeignClient;
import com.webacademy.shopping_cart.feign.StudentFeignClient;
import com.webacademy.shopping_cart.service.ShoppingCartServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
                .body("Successfully added course to cart");
    }

    @DeleteMapping("/delete/{cartId}/{courseId}")
    public ResponseEntity<String> removeCourseFromCart(@PathVariable("cartId") Long cartId,
                                                  @PathVariable("courseId") Long courseId){
        shoppingCartService.removeCourseFromCart(cartId, courseId);
        return ResponseEntity.status(HttpStatus.OK)
                .body("Successfully removed course from cart");
    }

    @PostMapping("/buy/{studentId}/{courseId}")
    public ResponseEntity<String> buyCourseFromCart(@PathVariable("studentId")Long studentId,
                                  @PathVariable("courseId") Long courseId){
        shoppingCartService.buyCourseFromCart(studentId, courseId);
        return ResponseEntity.status(HttpStatus.OK)
                .body("Successfully removed course from cart");
    }

}
