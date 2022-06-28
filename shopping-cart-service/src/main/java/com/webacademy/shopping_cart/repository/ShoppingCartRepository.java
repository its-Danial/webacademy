package com.webacademy.shopping_cart.repository;

import com.webacademy.common.entities.Course;
import com.webacademy.common.entities.ShoppingCart;
import com.webacademy.common.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart,Long> {

//    @Query("SELECT c, s FROM Course c, Student s WHERE c.courseId = ?1 and s.studentId = ?2")
//    void addCourseToCart(Optional<Course> course, Optional<Student> student);
}
