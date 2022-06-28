package com.webacademy.course.feign;

import com.webacademy.common.entities.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name="student-service", path = "/student")
public interface StudentFeignClient {

    @GetMapping("/get-all")
    List<Student> getAllStudent();
}
