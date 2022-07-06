package com.webacademy.teacher.controller;

import com.webacademy.common.entities.Teacher;
import com.webacademy.teacher.service.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teacher")
public class TeacherHomeController {

    @Autowired
    TeacherServiceImpl teacherService;

    @GetMapping("/get-all")
    @ResponseStatus(HttpStatus.OK)
    public List<Teacher> getAllTeacher(){
        return teacherService.findAllTeacher();
    }

    @GetMapping("/get-by-id/{teacherId}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Teacher> getTeacherById(@PathVariable("teacherId") Long id){
        return teacherService.findTeacherById(id);
    }

    @GetMapping("/get-by-email/{email}")
    @ResponseStatus(HttpStatus.OK)
    public Teacher getTeacherByEmail(@PathVariable("email") String email) {
        return teacherService.findTeacherByEmail(email);
    }
}
