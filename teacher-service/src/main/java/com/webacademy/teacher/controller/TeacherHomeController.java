package com.webacademy.teacher.controller;

import com.alibaba.fastjson.JSONObject;
import com.webacademy.common.entities.Teacher;
import com.webacademy.teacher.service.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teacher")
@CrossOrigin
public class TeacherHomeController {

    @Autowired
    TeacherServiceImpl teacherService;

    @GetMapping("/get-all")
    @ResponseStatus(HttpStatus.OK)
    public List<Teacher> getAllTeacher() {
        return teacherService.findAllTeacher();
    }

    @GetMapping("/get-by-id/{teacherId}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Teacher> getTeacherById(@PathVariable("teacherId") Long id) {
        return teacherService.findTeacherById(id);
    }

    @GetMapping("/get-by-email/{email}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Teacher> getTeacherByEmail(@PathVariable("email") String email) {
        try {

            return ResponseEntity.status(HttpStatus.OK).body(teacherService.findTeacherByEmail(email));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "No teacher found by email: " + email, e);
        }
    }

    @GetMapping("/get-by-username/{username}")
    public ResponseEntity<Teacher> getTeacherByUsername(@PathVariable("username") String username) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(teacherService.findTeacherByUsername(username));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "No teacher found by username: " + username, e);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Teacher> login(@RequestBody JSONObject credentials) {
        String email = credentials.getObject("email", String.class);
        String password = credentials.getObject("password", String.class);

        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(teacherService.login(email, password));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,
                    "Invalid email or password", e);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<Teacher> register(@RequestBody Teacher teacher) {
        try {
            String email = teacher.getEmail();
            String username = teacher.getUsername();
            String fullname = teacher.getFullName();
            String password = teacher.getPassword();
            return ResponseEntity.status(HttpStatus.OK)
                    .body(teacherService.register(email, username, fullname, password));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    "Email or username already exist", e);
        }
    }
}
