package com.webacademy.course.feign;

import com.webacademy.common.entities.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@FeignClient(name="student-service", path = "/student")
public interface StudentFeignClient {

    @GetMapping("/get-all")
    List<Student> getAllStudent();

    @GetMapping("/get-by-id/{studentId}")
    Optional<Student> getStudentById(@PathVariable("studentId") Long id);
}
