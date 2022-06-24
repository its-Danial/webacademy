package com.webacademy.course.controller;

import com.webacademy.common.entities.Course;
import com.webacademy.course.service.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseHomeController {

    @Autowired
    CourseServiceImpl courseService;

    @GetMapping("/get-all")
    public List<Course> getAllCourse() {
        return courseService.getAllCourse();
    }
}
