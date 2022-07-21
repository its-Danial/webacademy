package com.webacademy.student.feign;

import com.webacademy.common.entities.StudentProgress;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name="student-progress-service", path = "/progress")
public interface ProgressFeignClient {

    @DeleteMapping("/delete-by-student/{studentId}")
    ResponseEntity<String> deleteProgressesByStudentId(@PathVariable("studentId") Long studentId);
}
