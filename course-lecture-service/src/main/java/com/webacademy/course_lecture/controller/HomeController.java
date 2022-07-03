package com.webacademy.course_lecture.controller;

import com.webacademy.common.entities.CourseLecture;
import com.webacademy.course_lecture.service.CourseLectureServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/setCompleteProgress/{courseLectureId}")
    public void setCompletedProgress(@PathVariable("courseLectureId") Long id){
        CourseLecture courseLecture = courseLectureService.findLectureById(id).orElse(null);
        courseLectureService.setCompletedProgress(courseLecture);
    }

}
