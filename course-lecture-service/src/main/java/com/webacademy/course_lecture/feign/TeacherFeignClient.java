package com.webacademy.course_lecture.feign;

import com.webacademy.common.entities.Teacher;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name="teacher-service", path = "/teacher")
public interface TeacherFeignClient {

    @GetMapping("/getById/{teacherId}")
    public Optional<Teacher> getTeacherById(@PathVariable("teacherId") Long id);
}
