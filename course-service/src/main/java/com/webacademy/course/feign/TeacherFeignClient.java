package com.webacademy.course.feign;

import com.webacademy.common.entities.Teacher;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Optional;

@FeignClient(name="teacher-service", path = "/teacher")
public interface TeacherFeignClient {

    @GetMapping("/get-by-id/{teacherId}")
    Optional<Teacher> getTeacherById(@PathVariable("teacherId") Long id);

    @GetMapping("/get-all")
    List<Teacher> getAllTeacher();
}
