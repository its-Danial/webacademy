package com.webacademy.student.controller;

import com.webacademy.common.entities.Student;
import com.webacademy.student.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentHomeController {

    @Autowired
    StudentServiceImpl studentService;

    @GetMapping("/get-all")
    public List<Student> getAllStudent(){
        return studentService.findAllStudent();
    }

    @GetMapping("/getById/{studentId}")
    public Optional<Student> getStudentById(@PathVariable("studentId") Long id){
        return studentService.findStudentById(id);
    }

    @GetMapping("/getByEmail/{email}")
    public Student getStudentByEmail(@PathVariable("email") String email){
        return studentService.findStudentByEmail(email);
    }

    @GetMapping("/getStudentsByCourseId/{courseId}")
    public List<Student> getStudentsByCourseId(@PathVariable("courseId") Long id){
        return studentService.findStudentsByCourseId(id);
    }

}
