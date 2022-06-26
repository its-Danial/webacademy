package com.webacademy.teacher.controller;

import com.webacademy.common.entities.Teacher;
import com.webacademy.teacher.service.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherHomeController {

    @Autowired
    TeacherServiceImpl teacherService;

    @GetMapping("/get-all")
    public List<Teacher> getAllTeacher(){
        return teacherService.findAllTeacher();
    }

    @GetMapping("/getTeacherByEmail/{email}")
    public Teacher getTeacherByEmail(@PathVariable("email") String email) {
        return teacherService.findTeacherByEmail(email);
    }
}
