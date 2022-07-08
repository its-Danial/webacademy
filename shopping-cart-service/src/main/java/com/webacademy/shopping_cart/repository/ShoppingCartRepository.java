package com.webacademy.shopping_cart.repository;

import com.webacademy.common.entities.Course;
import com.webacademy.common.entities.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

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
//    @Query(value = "SELECT new web_academydb.course (c.* FROM course c LEFT OUTER JOIN " +
//            "cart_course_mapping cc ON c.course_id = cc.course_id " +
//            "LEFT OUTER JOIN shopping_cart sc ON cc.cart_id = sc.cart_id " +
//            "WHERE cc.cart_id = :studentId)", nativeQuery = true)
//    @Query(value = "SELECT c.* FROM course c JOIN cart_course_mapping cc ON c.course_id = cc.course_id WHERE cc.cart_id = :studentId", nativeQuery = true)
//    List<Course> findCoursesInCartByStudentId(@Param("studentId") Long id);
}

