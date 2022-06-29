package com.webacademy.course.repository;

import com.webacademy.common.entities.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course,Long> {

    @Query(value = "SELECT course_id, title, course_rating, price, " +
            "description, summary, cover_image_url, preview_video_url, created_at, " +
            "completed_progress, teacher_id FROM course", nativeQuery = true)
    List<Object> findAllCourseWithoutStudent();

    @Query("SELECT c FROM Course c WHERE c.teacher.teacherId = ?1")
    List<Course> findCoursesByTeacherId(Long id);

    @Query("SELECT c FROM Course c join fetch c.categories ca where ca.categoryName = :category")
    List<Course> findCoursesByCategory(@Param("category") String category);

    @Query("SELECT c FROM Course c join fetch c.categories ca where :topic MEMBER OF ca.topics ")
    List<Course> findCoursesByTopic(@Param("topic") String topic);

    @Override
    Page<Course> findAll(Pageable pageable);
}
