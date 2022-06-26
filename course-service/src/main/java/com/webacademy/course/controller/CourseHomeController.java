package com.webacademy.course.controller;

import com.webacademy.common.entities.Course;
import com.webacademy.course.service.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/course")
public class CourseHomeController {

    @Autowired
    CourseServiceImpl courseService;

    @GetMapping("/get-all")
    public List<Course> getAllCourse() {
        return courseService.findAllCourse();
    }

    @GetMapping("/getById/{courseId}")
    public Optional<Course> getCourseByCourseId(@PathVariable("courseId") Long id){
        return courseService.findCourseByCourseId(id);
    }

    @GetMapping("/getByTeacherId/{teacherId}")
    public List<Course> getCoursesByTeacherId(@PathVariable("teacherId") Long id){
        return courseService.findCoursesByTeacherId(id);
    }

    @GetMapping("/getByCategory/{category}")
    public List<Course> getCoursesByCategory(@PathVariable("category") String category){
        return  courseService.findCoursesByCategory(category);
    }


}
