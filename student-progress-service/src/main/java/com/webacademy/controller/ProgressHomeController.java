package com.webacademy.controller;

import com.webacademy.common.entities.StudentProgress;
import com.webacademy.repository.StudentProgressRepository;
import com.webacademy.service.StudentProgressServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/progress")
public class ProgressHomeController {

    @Autowired
    StudentProgressRepository studentProgressRepository;

    @Autowired
    StudentProgressServiceImpl studentProgressService;

    @GetMapping("get-all")
    public List<StudentProgress> getAllProgress() {

        return studentProgressService.getAllStudentProgress();
    }

    @GetMapping("/get-one/{studentId}/{courseId}")
    public StudentProgress getOneByStudentIdAndCourseId(@PathVariable("studentId") Long studentId,
                                                        @PathVariable("courseId") Long courseId) {

        return studentProgressService.getOneByStudentIdAndCourseId(studentId, courseId);
    }

    @PutMapping("/completed-one/{studentId}/{courseId}")
    public HttpStatus updateCompletedByOne(@PathVariable("studentId") Long studentId,
                                           @PathVariable("courseId") Long courseId) {

        studentProgressService.updateCompletedByOne(studentId, courseId);

        return HttpStatus.CREATED;
    }



}
