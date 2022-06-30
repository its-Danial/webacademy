package com.webacademy.shopping_cart.repository;

import com.webacademy.common.entities.Course;
import com.webacademy.common.entities.ShoppingCart;
import com.webacademy.common.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart,Long> {

//    @Query("SELECT c, s FROM Course c, Student s WHERE c.courseId = ?1 and s.studentId = ?2")
//    @Query("UPDATE ShoppingCart sh SET sh.course = :course")
//    @Query(value = "SELECT sc.cart_id, sc.student_id, cc.course_i " +
//            "FROM shopping_cart sc JOIN cart_course_mapping cc " +
//            "ON sc.cart_id = cc.cart_id WHERE " +
//            "course_id = :course.courseId AND student_id = :student.studentId ", nativeQuery = true)
//    //Delete later
//    List<Object> findShoppingCarts(@Param("course") Course course, @Param("student") Student student);

//    ShoppingCart addCourseToCart(@Param("course") Course course, @Param("student") Student student);
}
