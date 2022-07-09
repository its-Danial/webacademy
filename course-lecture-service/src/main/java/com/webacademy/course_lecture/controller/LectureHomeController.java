package com.webacademy.course_lecture.controller;

import com.webacademy.common.entities.CourseLecture;
import com.webacademy.course_lecture.feign.ProgressFeignClient;
import com.webacademy.course_lecture.service.CourseLectureServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lecture")
@CrossOrigin
public class LectureHomeController {

    @Autowired
    CourseLectureServiceImpl courseLectureService;

    @Autowired
    ProgressFeignClient progressFeignClient;

    @GetMapping("/get-by-course-id/{courseId}")
    @ResponseStatus(HttpStatus.OK)
    public List<CourseLecture> getLecturesByCourse(@PathVariable("courseId") Long id){
        return courseLectureService.findLecturesByCourseId(id);
    }

    @GetMapping("/get-by-id/{courseLectureId}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<CourseLecture> getLectureById(@PathVariable("courseLectureId") Long id){
        return courseLectureService.findLectureById(id);
    }

    @PostMapping("/add/{teacherId}/{courseId}")
    public ResponseEntity<String> addLecture(@PathVariable("teacherId") Long teacherId,
                                             @PathVariable("courseId") Long courseId,
                                             @RequestBody CourseLecture courseLecture){
        courseLectureService.addLecture(teacherId, courseId, courseLecture);
        progressFeignClient.updateTotalLectures(courseId);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Teacher " + teacherId + " has successfully added lecture "
                        + courseLecture.getCourseLectureId() + " to course " + courseId);
    }

    @PostMapping("/add-multiple/{teacherId}/{courseId}")
    public ResponseEntity<String> addLectures(@PathVariable("teacherId") Long teacherId,
                                              @PathVariable("courseId") Long courseId,
                                              @RequestBody List<CourseLecture> courseLectures){
        courseLectureService.addMultipleLectures(teacherId, courseId, courseLectures);

        progressFeignClient.updateTotalLectures(courseId);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Teacher " + teacherId + " has successfully added " +
                        "multiple lectures to course " + courseId);
    }

    @DeleteMapping("/delete/{teacherId}/{courseId}/{lectureId}")
    public ResponseEntity<String> deleteLecture(@PathVariable("teacherId") Long teacherId,
                                                @PathVariable("courseId") Long courseId,
                                                @PathVariable("lectureId") Long lectureId){
        courseLectureService.deleteLecture(teacherId, courseId, lectureId);
        progressFeignClient.updateTotalLectures(courseId);
        return ResponseEntity.status(HttpStatus.OK)
                .body("Teacher " + teacherId + " has successfully deleted lecture "
                        + lectureId + " from course " + courseId);
    }
}
