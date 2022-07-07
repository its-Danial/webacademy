package com.webacademy.student.controller;

import com.alibaba.nacos.api.naming.pojo.healthcheck.impl.Http;
import com.webacademy.common.entities.Student;
import com.webacademy.student.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentHomeController {

    @Autowired
    StudentServiceImpl studentService;

    @GetMapping("/get-all")
    @ResponseStatus(HttpStatus.OK)
    public List<Student> getAllStudent(){
        return studentService.findAllStudent();
    }

    @GetMapping("/get-by-id/{studentId}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Student> getStudentById(@PathVariable("studentId") Long id){
        return studentService.findStudentById(id);
    }

    @GetMapping("/get-by-email/{email}")
    public ResponseEntity<Student> getStudentByEmail(@PathVariable("email") String email){
        try {

            return ResponseEntity.status(HttpStatus.OK).body(studentService.findStudentByEmail(email));
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "No username found by email: " + email, e);
        }
    }

    @GetMapping("/get-by-username/{username}")
    public ResponseEntity<Student> getStudentByUsername(@PathVariable("username") String username){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(studentService.findStudentByUsername(username));
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "No username found by username: " + username, e);
        }
    }
    @PostMapping("/login/{username}/{password}")
    public ResponseEntity<Student> login(@PathVariable("username") String username,
                                         @PathVariable("password") String password){
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(studentService.login(username, password));
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,
                    "Invalid username or password", e);
        }
    }

    @GetMapping("/get-all-by-course-id/{courseId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Student> getStudentsByCourseId(@PathVariable("courseId") Long id){
        return studentService.findStudentsByCourseId(id);
    }

    @GetMapping("/get-by-course-id-and-student-id/{courseId}/{studentId}")
    public Student getStudentByCourseIdAndStudentId(@PathVariable("courseId") Long courseId,
                                                    @PathVariable("studentId") Long studentId){
        return studentService.findStudentByCourseIdAndStudentId(courseId, studentId);
    }


}
