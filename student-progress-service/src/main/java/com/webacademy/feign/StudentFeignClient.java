package com.webacademy.feign;

import com.webacademy.common.entities.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Optional;

@FeignClient(name="student-service", path = "/student")
public interface StudentFeignClient {

    @GetMapping("/get-all-by-course-id/{courseId}")
    List<Student> getStudentsByCourseId(@PathVariable("courseId") Long id);

    @GetMapping("/get-by-id/{studentId}")
    Optional<Student> getStudentById(@PathVariable("studentId") Long id);

    @GetMapping("/get-by-course-id-and-student-id/{courseId}/{studentId}")
    Student getStudentByCourseIdAndStudentId(@PathVariable("courseId") Long courseId,
                                                    @PathVariable("studentId") Long studentId);
}
