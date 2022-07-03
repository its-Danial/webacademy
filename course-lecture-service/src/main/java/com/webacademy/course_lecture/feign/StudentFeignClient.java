package com.webacademy.course_lecture.feign;

import com.webacademy.common.entities.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="student-service", path = "/student")
public interface StudentFeignClient {

    @GetMapping("/getStudentsByCourseId/{courseId}")
    List<Student> getStudentsByCourseId(@PathVariable("courseId") Long id);
}
