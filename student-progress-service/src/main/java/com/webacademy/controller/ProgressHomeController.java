package com.webacademy.controller;

import com.webacademy.common.entities.StudentProgress;
import com.webacademy.service.StudentProgressServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/progress")
@CrossOrigin
public class ProgressHomeController {

    @Autowired
    StudentProgressServiceImpl studentProgressService;

    @GetMapping("/get-all")
    @ResponseStatus(HttpStatus.OK)
    public List<StudentProgress> getAllProgress() {

        return studentProgressService.findAllStudentProgress();
    }

    @GetMapping("/get-all-by-student-id/{studentId}")
    @ResponseStatus(HttpStatus.OK)
    public List<StudentProgress> getProgressesByStudentId(@PathVariable("studentId") Long studentId) {
        return studentProgressService.findProgressesByStudentId(studentId);
    }

    @GetMapping("/get-all-by-course-id/{courseId}")
    @ResponseStatus(HttpStatus.OK)
    public List<StudentProgress> getProgressesByCourseId(@PathVariable("courseId") Long courseId) {
        return studentProgressService.findProgressesByCourseId(courseId);
    }


    @GetMapping("/get-one/{studentId}/{courseId}")
    @ResponseStatus(HttpStatus.OK)
    public StudentProgress getProgressByStudentIdAndCourseId(@PathVariable("studentId") Long studentId,
                                                             @PathVariable("courseId") Long courseId) {

        return studentProgressService.findProgressByStudentIdAndCourseId(studentId, courseId);
    }

    @PutMapping("/completed-one/{studentId}/{courseId}")
    public ResponseEntity<String> updateCompletedByOne(@PathVariable("studentId") Long studentId,
                                                       @PathVariable("courseId") Long courseId) {

        studentProgressService.updateCompletedByOne(studentId, courseId);

        return ResponseEntity.status(HttpStatus.OK)
                .body("Successfully updated a lecture to completed");
    }

    @PutMapping("/like-course/{studentId}/{courseId}")
    public ResponseEntity<String> likeCourse(@PathVariable("studentId") Long studentId,
                                             @PathVariable("courseId") Long courseId) {
        studentProgressService.likeCourse(studentId, courseId);

        return ResponseEntity.status(HttpStatus.OK)
                .body("Successfully liked the course");
    }

    @PutMapping("/unlike-course/{studentId}/{courseId}")
    public ResponseEntity<String> unlikeCourse(@PathVariable("studentId") Long studentId,
                                               @PathVariable("courseId") Long courseId) {
        studentProgressService.unlikeCourse(studentId, courseId);

        return ResponseEntity.status(HttpStatus.OK)
                .body("Successfully unliked the course");
    }

    @PostMapping("/insert-progress/{studentId}/{courseId}")
    public ResponseEntity<String> insertProgressByStudentIdAndCourseId(@PathVariable("studentId") Long studentId,
                                                                       @PathVariable("courseId") Long courseId) {
        studentProgressService.insertProgressByStudentIdAndCourseId(studentId, courseId);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Created progress for student " + studentId + " on course " + courseId);
    }

    @PutMapping("/update-total-lectures/{courseId}")
    public ResponseEntity<String> updateTotalLectures(@PathVariable("courseId") Long courseId) {

        studentProgressService.updateTotalLectures(courseId);
        return ResponseEntity.status(HttpStatus.OK)
                .body("Updated total lectures for course " + courseId);
    }

    @DeleteMapping("/delete/{courseId}")
    public ResponseEntity<String> deleteProgressesByCourseId(@PathVariable("courseId") Long courseId){
        studentProgressService.deleteProgressesByCourseId(courseId);
        return ResponseEntity.status(HttpStatus.OK)
                .body("Deleted progress by course " + courseId);
    }

}
