package com.webacademy.course_lecture.controller;

import com.webacademy.common.entities.CourseLecture;
import com.webacademy.course_lecture.service.CourseLectureServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lecture")
public class HomeController {

    @Autowired
    CourseLectureServiceImpl courseLectureService;

    @GetMapping("/getByCourseId/{courseId}")
    public List<CourseLecture> getLecturesByCourse(@PathVariable("courseId") Long id){
        return courseLectureService.findLecturesByCourseId(id);
    }

    @GetMapping("/getById/{courseLectureId}")
    public Optional<CourseLecture> getLectureById(@PathVariable("courseLectureId") Long id){
        return courseLectureService.findLectureById(id);
    }

}
