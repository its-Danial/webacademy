package com.webacademy.shopping_cart.repository;

import com.webacademy.common.entities.Course;
import com.webacademy.common.entities.ShoppingCart;
import com.webacademy.common.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart,Long> {

    // To use queries that would change the data, we need @Modifying, and @Transactional in the service class
    @Modifying
    @Query(value = "INSERT INTO cart_course_mapping(cart_id, course_id) VALUES (:cartId, :courseId)", nativeQuery = true)
    void addCourseToCart(@Param("cartId") Long cartId, @Param("courseId") Long courseId);

    @Modifying
    @Query(value = "DELETE FROM cart_course_mapping WHERE cart_id = :cartId AND course_id = :courseId", nativeQuery = true)
    void removeCourseFromCart(@Param("cartId") Long cartId, @Param("courseId") Long courseId);
}

