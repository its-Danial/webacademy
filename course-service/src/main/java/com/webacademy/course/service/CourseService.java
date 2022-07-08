package com.webacademy.course.service;

import com.webacademy.common.entities.Category;
import com.webacademy.common.entities.Course;
import com.webacademy.common.entities.CourseInformation;
import com.webacademy.common.entities.Teacher;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface CourseService {

    String hello();

    List<Course> findAllCourse();

//    List<Object> findAllCourseWithoutStudent();
    List<Course> findCoursesByPage(int page, int size);

    List<Course>findCoursesByTeacherId(Long id);

    List<Course> findCoursesByCategory(String category);

    List<Course> findCoursesByTopic(String topic);

    List<Course> findCourseByRating(double minRating, double maxRating);

    Optional<Course> findCourseByCourseId(Long id);

    List<Course> findCoursesByStudentId(Long id);

    void createCourse(Long teacherId, Course course);

    void deleteCourse(Long teacherId, Long courseId);

    List<Course> findCoursesInCartByStudentId(Long studentId);

    int countBoughtCourseByCourseId(Long courseId);
}
