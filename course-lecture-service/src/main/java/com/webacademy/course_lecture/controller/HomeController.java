package com.webacademy.course_lecture.controller;

import com.webacademy.common.entities.CourseLecture;
import com.webacademy.course_lecture.service.CourseLectureServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/course-lecture")
public class HomeController {

//    @GetMapping("/getall")
    CourseLectureServiceImpl courseLectureService;

    // todo: find Course lecture by course
    @GetMapping("/getLectureByCourse/{courseId}")
    public List<CourseLecture> getLectureByCourse(@PathVariable("courseId") Long id){
        return courseLectureService.findLecturesByCourseId(id);
    }
}
