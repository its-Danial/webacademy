package com.webacademy.course.service;

import com.webacademy.common.entities.Course;


import java.util.List;
import java.util.Optional;

public interface CourseService {

    List<Course> findAllCourse();

    List<Course>findCoursesByTeacherId(Long id);

    List<Course>findCoursesByCategory(String category);

    Optional<Course> findCourseByCourseId(Long id);
}
