package com.webacademy.course.service;

import com.webacademy.common.entities.Course;


import java.util.List;
import java.util.Optional;

public interface CourseService {

    String hello();

    List<Course> findAllCourse();

    List<Object> findAllCourseWithoutStudent();
    List<Course> findCoursesByPage(int page, int size);

    List<Course>findCoursesByTeacherId(Long id);

    List<Course> findCoursesByCategory(String category);

    List<Course> findCoursesByTopic(String topic);

    Optional<Course> findCourseByCourseId(Long id);

    void updateProgress(Course course);
}
