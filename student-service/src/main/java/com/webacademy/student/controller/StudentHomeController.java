package com.webacademy.student.controller;

import com.webacademy.common.entities.Student;
import com.webacademy.student.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentHomeController {

    @Autowired
    StudentServiceImpl studentService;

    @GetMapping("/get-all")
    public List<Student> getAllStudent(){
        return studentService.getAllStudent();
    }

    @GetMapping("/getStudentByEmail/{email}")
    public Student getStudentByEmail(@PathVariable("email") String email){
        return studentService.findStudentByEmail(email);
    }

}
