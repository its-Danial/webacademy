//package com.webacademy.shopping_cart.config;
//
//import com.webacademy.common.entities.Course;
//import com.webacademy.common.entities.ShoppingCart;
//import com.webacademy.common.entities.Student;
//import com.webacademy.shopping_cart.feign.CourseFeignClient;
//import com.webacademy.shopping_cart.feign.StudentFeignClient;
//import com.webacademy.shopping_cart.repository.ShoppingCartRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.Arrays;
//import java.util.Optional;
//
//@Configuration
//public class ShoppingCartConfig {
//
//    @Autowired
//    CourseFeignClient courseFeignClient;
//    @Autowired
//    StudentFeignClient studentFeignClient;
//    @Bean
//    CommandLineRunner commandLineRunner(ShoppingCartRepository shoppingCartRepository) {
//        return args -> {
//
//
//            Course course1 = courseFeignClient.getCourseByCourseId(1L).get();
//            Course course2 = courseFeignClient.getCourseByCourseId(2L).get();
//
//            Student danial = studentFeignClient.getStudentById(1L).get();
//
//            ShoppingCart shoppingCart = ShoppingCart.builder()
//                    .courses(Arrays.asList(course1, course2))
//                    .student(danial)
//                    .build();
//
//            shoppingCartRepository.save(shoppingCart);
//        };
//    }
//}
