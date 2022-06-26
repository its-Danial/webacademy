package com.webacademy.shopping_cart.feign;

import com.webacademy.common.entities.Course;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class CartFeignClientImpl implements CartFeignClient{


    @Override
    public List<Course> getAllCourses() {
        throw new IllegalStateException( "Open Feign Failed to get all Courses");
    }
}
