package com.webacademy.shopping_cart.repository;

import com.webacademy.common.entities.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart,Long> {

    @Modifying
    @Query(value = "INSERT INTO shopping_cart VALUES(:studentId)", nativeQuery = true)
    void createCart(@Param("studentId") Long studentId);

    @Modifying
    @Query(value = "INSERT INTO cart_course_mapping(cart_id, course_id) VALUES (:cartId, :courseId)", nativeQuery = true)
    void addCourseToCart(@Param("cartId") Long cartId, @Param("courseId") Long courseId);

    @Modifying
    @Query(value = "DELETE FROM cart_course_mapping WHERE cart_id = :cartId AND course_id = :courseId", nativeQuery = true)
    void removeCourseFromCart(@Param("cartId") Long cartId, @Param("courseId") Long courseId);

    @Modifying
    @Query(value = "INSERT INTO student_course_mapping(course_id, student_id) VALUES (:courseId, :studentId)", nativeQuery = true)
    void buyCourseFromCart(@Param("studentId") Long studentId, @Param("courseId") Long courseId);

    @Query(value = "SELECT IF(COUNT(*) > 0, 'true', 'false') FROM cart_course_mapping WHERE cart_id = :cartId AND course_id = :courseId", nativeQuery = true)
    boolean existsByCartIdAndCourseId(@Param("cartId") Long cartId, @Param("courseId") Long courseId);

    @Query(value = "SELECT IF(COUNT(*) > 0, 'true', 'false') FROM student_course_mapping WHERE student_id = :studentId AND course_id = :courseId", nativeQuery = true)
    boolean existsByStudentIdAndCourseId(@Param("studentId") Long studentId, @Param("courseId") Long courseId);

    @Query(value = "SELECT IF(COUNT(*) > 0, 'true', 'false') FROM cart_course_mapping WHERE cart_id = :cartId", nativeQuery = true)
    boolean existsByCartId(@Param("cartId") Long cartId);
}

