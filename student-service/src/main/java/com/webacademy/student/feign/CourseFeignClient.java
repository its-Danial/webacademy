package com.webacademy.student.feign;

import com.webacademy.common.entities.Course;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="course-service", path = "/course")
public interface CourseFeignClient {

    @GetMapping("/get-by-teacher-id/{teacherId}")
    List<Course> getCoursesByTeacherId(@PathVariable("teacherId") Long id);
}
