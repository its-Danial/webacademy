package com.webacademy.course_lecture.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name="student-progress-service", path = "/progress")
public interface ProgressFeignClient {

    @PutMapping("/update-total-lectures/{courseId}")
    void updateTotalLectures(@PathVariable("courseId") Long courseId);
}
