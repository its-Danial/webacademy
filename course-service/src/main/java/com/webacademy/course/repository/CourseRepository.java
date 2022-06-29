package com.webacademy.course.repository;

import com.webacademy.common.entities.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course,Long> {

//    @Query("SELECT c.courseId, c.title, c.courseInformation, " +
//            "c.courseRating, c.createdAt, c.categories, " +
//            "c.completedProgress, c.teacher FROM Course c ")
//    @Query("SELECT c FROM Course c")
//    List<Course> findAllCourseWithoutStudent();

    @Query("SELECT c FROM Course c WHERE c.teacher.teacherId = ?1")
    List<Course> findCoursesByTeacherId(Long id);

    @Query("SELECT c FROM Course c join fetch c.categories ca where ca.categoryName = :category")
    List<Course> findCoursesByCategory(@Param("category") String category);

    @Query("SELECT c FROM Course c join fetch c.categories ca where :topic MEMBER OF ca.topics ")
    List<Course> findCoursesByTopic(@Param("topic") String topic);

    @Override
    Page<Course> findAll(Pageable pageable);
}
