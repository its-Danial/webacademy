package com.webacademy.shopping_cart.service;

import com.webacademy.common.entities.Course;
import com.webacademy.common.entities.ShoppingCart;
import com.webacademy.common.entities.Student;
import com.webacademy.shopping_cart.feign.CourseFeignClient;
import com.webacademy.shopping_cart.feign.LectureFeignClient;
import com.webacademy.shopping_cart.feign.ProgressFeignClient;
import com.webacademy.shopping_cart.feign.StudentFeignClient;
import com.webacademy.shopping_cart.repository.ShoppingCartRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
    @Autowired
    ProgressFeignClient progressFeignClient;
    @Autowired
    LectureFeignClient lectureFeignClient;

    @Override
    public void createCart(Long studentId) {
        shoppingCartRepository.createCart(studentId);
        log.info("Created cart {}", studentId);
    }

    @Override
    public ShoppingCart findCartById(Long cartId) {
        log.info("Fetch cart {}", cartId);
        return shoppingCartRepository.findById(cartId).
                orElseThrow(()-> new IllegalArgumentException("Cart not found"));
    }

    @Override
    public void addCourseToCart(Long cartId, Long courseId) {
        Course c = courseFeignClient.getCourseByCourseId(courseId).
                orElseThrow(()-> new IllegalArgumentException("Course not found"));
        ShoppingCart sc = shoppingCartRepository.findById(cartId).
                orElseThrow(()-> new IllegalArgumentException("Student cart not found"));

        //If exists duplicate
        if(shoppingCartRepository.existsByCartIdAndCourseId(cartId,courseId)){
            throw new IllegalStateException("Student " + cartId + " already has course "
                    + courseId + " in cart");
        }

        //If student already bought the course
        if(shoppingCartRepository.existsByStudentIdAndCourseId(cartId, courseId)){
            throw new IllegalStateException("Student " + cartId + " already has course "
                    + courseId + " purchased");
        }

        shoppingCartRepository.addCourseToCart(sc.getCartId(), c.getCourseId());
        log.info("{} added Course {} to cart", sc.getStudent().getFullName(), c.getTitle());
    }

    @Override
    public void removeCourseFromCart(Long cartId, Long courseId) {
        Course c = courseFeignClient.getCourseByCourseId(courseId).
                orElseThrow(()-> new IllegalArgumentException("Course not found"));
        ShoppingCart sc = shoppingCartRepository.findById(cartId).
                orElseThrow(()-> new IllegalArgumentException("Student cart not found"));

        //Check if exists mapping in cart
        if(!shoppingCartRepository.existsByCartIdAndCourseId(cartId,courseId)){
            throw new IllegalStateException("Student " + cartId + " doesn't have course "
                    + courseId + " in cart");
        }

        shoppingCartRepository.removeCourseFromCart(cartId, courseId);
        log.info("Removed course {} from cart {}", courseId, cartId);
    }

    @Override
    public void buyAllCourseFromCart(Long studentId) {
        Student student = studentFeignClient.getStudentById(studentId).
                orElseThrow(()-> new IllegalArgumentException("Student not found"));
        List<Course> courses = courseFeignClient.getCoursesInCartByStudentId(studentId);
        //if cart exists the id
        if(shoppingCartRepository.existsByCartId(studentId)){
            for (Course course: courses) {
                shoppingCartRepository.buyCourseFromCart(studentId, course.getCourseId());
                shoppingCartRepository.removeCourseFromCart(studentId, course.getCourseId());
                log.info("Student {} has owned course {}",student.getFullName(), course.getTitle());

                //Insert progress after owning course
                progressFeignClient.insertProgressByStudentIdAndCourseId(studentId, course.getCourseId());
            }
        } else {
            throw new IllegalStateException("Cart is empty");
        }

    }
}
