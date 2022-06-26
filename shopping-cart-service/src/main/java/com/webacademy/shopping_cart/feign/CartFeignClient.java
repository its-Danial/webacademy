package com.webacademy.shopping_cart.feign;

import com.webacademy.common.entities.Course;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@FeignClient(name = "course-service", path = "/course")
public interface CartFeignClient {

@LoadBalanced
    @GetMapping("/get-all")
    List<Course> getAllCourses();
}
