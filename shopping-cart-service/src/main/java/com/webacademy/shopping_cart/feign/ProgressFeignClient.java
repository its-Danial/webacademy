package com.webacademy.shopping_cart.feign;

import com.webacademy.common.entities.StudentProgress;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@FeignClient(name="student-progress-service", path = "/progress")
public interface ProgressFeignClient {

    @PostMapping("/insert-progress/{studentId}/{courseId}")
    ResponseEntity<String> insertProgressByStudentIdAndCourseId(@PathVariable("studentId") Long studentId,
                                                                @PathVariable("courseId") Long courseId);

    @GetMapping("/get-one/{studentId}/{courseId}")
    StudentProgress getProgressByStudentIdAndCourseId(@PathVariable("studentId") Long studentId,
                                                      @PathVariable("courseId") Long courseId);
}
