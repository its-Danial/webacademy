package com.webacademy.shopping_cart.config;

import com.webacademy.common.entities.Course;
import com.webacademy.common.entities.ShoppingCart;
import com.webacademy.common.entities.Student;
import com.webacademy.common.repositories.CourseRepository;
import com.webacademy.common.repositories.ShoppingCartRepository;
import com.webacademy.common.repositories.StudentRepository;
import com.webacademy.shopping_cart.feign.CartFeignClient;
import com.webacademy.shopping_cart.feign.HomeFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class ShoppingCartConfig {



//    @Bean
//    CommandLineRunner commandLineRunner( CartFeignClient cartFeignClient,ShoppingCartRepository shoppingCartRepository,
//                                        CourseRepository courseRepository,
//                                        StudentRepository studentRepository
//                                        ) {
//        return args -> {
//
//
//
//
//            System.out.println( cartFeignClient.getAllCourses());
//
//            Course course1 = courseRepository.findById(Long.valueOf(1)).get();
//            Course course2 = courseRepository.findById(Long.valueOf(2)).get();
//
//            Student danial = studentRepository.findStudentByEmail("danial@email.com");
//
//            ShoppingCart shoppingCart = ShoppingCart.builder()
//                    .course(Arrays.asList(course1, course2))
//                    .student(danial)
//                    .build();
//
//            shoppingCartRepository.save(shoppingCart);
//        };
//    }

//    @Bean CommandLineRunner commandLineRunner (HomeFeignClient homeFeignClient){
//        return args ->{
//
//            System.out.println(homeFeignClient.getAllTodos());
//        };
//    }
}
