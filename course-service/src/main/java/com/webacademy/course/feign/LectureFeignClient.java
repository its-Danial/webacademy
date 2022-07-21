package com.webacademy.course.feign;

import com.webacademy.common.entities.CourseLecture;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="course-lecture-service", path = "/lecture")
public interface LectureFeignClient {

    @GetMapping("/get-by-course-id/{courseId}")
    List<CourseLecture> getLecturesByCourse(@PathVariable("courseId") Long id);

    @DeleteMapping("/delete/{teacherId}/{courseId}/{lectureId}")
    ResponseEntity<String> deleteLecture(@PathVariable("teacherId") Long teacherId,
                                         @PathVariable("courseId") Long courseId,
                                         @PathVariable("lectureId") Long lectureId);
}
