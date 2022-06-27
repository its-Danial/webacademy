package com.webacademy.course.service;

import com.webacademy.common.entities.Course;
import com.webacademy.course.repository.CourseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("courseService")
@Slf4j
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Override
    public String hello() {
        return "hello";
    }

    @Override
    public List<Course> findAllCourse() {
        log.info("Fetch all courses");
        return courseRepository.findAll();
    }

    @Override
    public List<Course> findCoursesByTeacherId(Long id) {
        log.info("Fetch courses by teacher: {}", id);
        return courseRepository.findCoursesByTeacherId(id);
    }

//    @Override
//    public List<Course> findCoursesByCategory(String category) {
//        log.info("Fetch courses by category: {}", category);
//        return courseRepository.findCoursesByCategory(category);
//    }

    @Override
    public Optional<Course> findCourseByCourseId(Long id) {
        log.info("Fetch course {}", id);
        return courseRepository.findById(id);
    }


}
