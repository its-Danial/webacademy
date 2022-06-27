package com.webacademy.course.repository;

import com.webacademy.common.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course,Long> {



//    todo : find teacher name for the course
    @Query("SELECT c FROM Course c WHERE c.teacher.teacherId = ?1")
    List<Course> findCoursesByTeacherId(Long id);

//    @Query("SELECT c FROM Course c WHERE c.courseInformation.categoryTopic = ?1")
//    List<Course> findCoursesByCategory(String category);

}
