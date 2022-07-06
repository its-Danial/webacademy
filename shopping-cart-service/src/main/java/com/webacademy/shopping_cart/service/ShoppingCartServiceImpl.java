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

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service("shoppingCartService")
@Slf4j
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Autowired
    ShoppingCartRepository shoppingCartRepository;
    @Autowired
    CourseFeignClient courseFeignClient;
    @Autowired
    StudentFeignClient studentFeignClient;

    @Override
    public void addCourseToCart(Long cartId, Long courseId) {
        Course c = courseFeignClient.getCourseByCourseId(courseId).orElse(null);
        ShoppingCart sc = shoppingCartRepository.findById(cartId).orElse(null);
        shoppingCartRepository.addCourseToCart(sc.getCartId(), c.getCourseId());
        log.info("{} added Course {} to cart", sc.getStudent().getFullName(), c.getTitle());
    }

    @Override
    public void removeCourseFromCart(Long cartId, Long courseId) {
        shoppingCartRepository.removeCourseFromCart(cartId, courseId);
        log.info("Removed course no:{} from cart no:{}", courseId, cartId);
    }

    @Override
    public void buyCourseFromCart(Long studentId, Long courseId) {
        Student student = studentFeignClient.getStudentById(studentId).orElse(null);
        Course course = courseFeignClient.getCourseByCourseId(courseId).orElse(null);
        //TODO: check if cart has course
        //if(shoppingCartRepository.exists())

        shoppingCartRepository.buyCourseFromCart(studentId, courseId);
        shoppingCartRepository.removeCourseFromCart(studentId, courseId);
        log.info("Student {} has owned course {}",student.getFullName(), course.getTitle());
    }
}
