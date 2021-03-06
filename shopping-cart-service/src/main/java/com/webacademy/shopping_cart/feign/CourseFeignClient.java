package com.webacademy.shopping_cart.feign;

import com.webacademy.common.entities.Course;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@FeignClient(name="course-service", path = "/course")
public interface CourseFeignClient {

    @GetMapping("/get-by-id/{courseId}")
    Optional<Course> getCourseByCourseId(@PathVariable("courseId") Long id);

    @GetMapping("/get-course-in-cart/{studentId}")
    List<Course> getCoursesInCartByStudentId(@PathVariable("studentId") Long studentId);

}
