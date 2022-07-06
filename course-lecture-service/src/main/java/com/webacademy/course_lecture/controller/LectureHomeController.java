package com.webacademy.course_lecture.controller;

import com.webacademy.common.entities.Course;
import com.webacademy.common.entities.CourseLecture;
import com.webacademy.course_lecture.service.CourseLectureServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lecture")
public class LectureHomeController {

    @Autowired
    CourseLectureServiceImpl courseLectureService;

    @GetMapping("/get-by-course-id/{courseId}")
    @ResponseStatus(HttpStatus.OK)
    public List<CourseLecture> getLecturesByCourse(@PathVariable("courseId") Long id){
        return courseLectureService.findLecturesByCourseId(id);
    }

    @GetMapping("/get-by-id/{courseLectureId}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<CourseLecture> getLectureById(@PathVariable("courseLectureId") Long id){
        return courseLectureService.findLectureById(id);
    }

    @PostMapping("/add/{teacherId}/{courseId}")
    @ResponseStatus(HttpStatus.CREATED)
    public HttpStatus addLecture(@PathVariable("teacherId") Long teacherId,
                           @PathVariable("courseId") Long courseId,
                           @RequestBody CourseLecture courseLecture){
        courseLectureService.addLecture(teacherId, courseId, courseLecture);
        return HttpStatus.CREATED;
    }
}
