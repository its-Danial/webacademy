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
//
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
//            Student student = new Student(null, "bla", "email", "username", "password");
//
//            // Gives me "detached entity passed to persist" error when using feign to get student
////            Student student = studentFeignClient.getStudentById(2L).orElse(null);
//            System.out.println("==== " + student);
//
//            Course course1 = courseFeignClient.getCourseByCourseId(1L).orElse(null);
//
//            ShoppingCart shoppingCart = new ShoppingCart( null, student, Arrays.asList(course1));
//
//            shoppingCartRepository.save(shoppingCart);
//
//
////            Course course2 = courseFeignClient.getCourseByCourseId(2L).orElse(null);
////
////
////            Student melvern = studentFeignClient.getStudentById(Long.valueOf(2)).orElse(null);
////
////            ShoppingCart shoppingCart1 = ShoppingCart.builder()
////                    .courses(Arrays.asList(course1, course2))
////                    .student(danial)
////                    .build();
////
////            ShoppingCart shoppingCart2 = ShoppingCart.builder()
////                    .courses(Arrays.asList(course1))
////                    .student(melvern)
////                    .build();
////
////            shoppingCartRepository.save(shoppingCart1);
////            shoppingCartRepository.save(shoppingCart2);
//        };
//    }
//}
