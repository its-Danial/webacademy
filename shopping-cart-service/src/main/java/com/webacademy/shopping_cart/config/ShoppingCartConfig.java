//package com.webacademy.shopping_cart.config;
//
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class ShoppingCartConfig {



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
//}
