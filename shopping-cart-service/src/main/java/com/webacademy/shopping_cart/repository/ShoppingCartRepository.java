package com.webacademy.shopping_cart.repository;

import com.webacademy.common.entities.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart,Long> {

//    @Query("SELECT c, s FROM Course c, Student s WHERE c.courseId = ?1 and s.studentId = ?2")
//    void addCourseToCart(Long courseId, Long studentId);
}
