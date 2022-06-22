package com.webacademy.student.controller;

import com.webacademy.common.entities.Student;
import com.webacademy.student.services.StudentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentHomeController {

    @Autowired
    StudentServiceImp studentService;


    @GetMapping("/get-all")
   public List<Student> getAllStudent(){
        return studentService.getAllStudent();
    }


}
