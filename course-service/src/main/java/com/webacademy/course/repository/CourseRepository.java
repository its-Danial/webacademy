package com.webacademy.course.repository;

import com.webacademy.common.entities.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course,Long> {

    @Query("SELECT c FROM Course c WHERE c.teacher.teacherId = ?1")
    List<Course> findCoursesByTeacherId(Long id);

    @Query("SELECT c FROM Course c join fetch c.categories ca where ca.categoryName = :category")
    List<Course> findCoursesByCategory(@Param("category") String category);

    @Query("SELECT c FROM Course c join fetch c.categories ca where :topic MEMBER OF ca.topics")
    List<Course> findCoursesByTopic(@Param("topic") String topic);

    @Query("SELECT c FROM Course c WHERE c.courseRating BETWEEN :minRating AND :maxRating")
    List<Course> findCourseByRating(@Param("minRating") double minRating, @Param("maxRating") double maxRating);

    @Query("SELECT c FROM Course c join fetch c.students s WHERE s.studentId = :studentId")
    List<Course> findCoursesByStudentId(@Param("studentId") Long id);

    @Override
    Page<Course> findAll(Pageable pageable);

    @Query(value = "SELECT c.* FROM course c JOIN cart_course_mapping cc ON c.course_id = cc.course_id WHERE cc.cart_id = :studentId", nativeQuery = true)
    List<Course> findCoursesInCartByStudentId(@Param("studentId") Long id);

    @Query(value = "SELECT count(*) FROM student_course_mapping WHERE course_id = :courseId", nativeQuery = true)
    int countBoughtCourseByCourseId(@Param("courseId") Long courseId);
}
