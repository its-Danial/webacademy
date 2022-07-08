package com.webacademy.course.controller;

import com.webacademy.common.entities.Course;
import com.webacademy.common.entities.Teacher;
import com.webacademy.course.repository.CourseRepository;
import com.webacademy.course.service.CourseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/course")
public class CourseHomeController {

    @Autowired
    CourseServiceImpl courseService;

    @GetMapping("/get-all")
    public List<Course> getAllCourse(){
        return courseService.findAllCourse();
    }

    @GetMapping("/filter")
    @ResponseStatus(HttpStatus.OK)
    public List<Course> getCoursesByPage(@RequestParam int page, @RequestParam int size){
        return courseService.findCoursesByPage(page, size);
    }

    @GetMapping("/get-by-id/{courseId}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Course> getCourseByCourseId(@PathVariable("courseId") Long id){
        return courseService.findCourseByCourseId(id);
    }

    @GetMapping("/get-by-teacher-id/{teacherId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Course> getCoursesByTeacherId(@PathVariable("teacherId") Long id){
        return courseService.findCoursesByTeacherId(id);
    }

    @GetMapping("/get-by-student-id/{studentId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Course> getCoursesByStudentId(@PathVariable("studentId") Long id){
        return courseService.findCoursesByStudentId(id);
    }

    @GetMapping("/get-by-category/{category}")
    @ResponseStatus(HttpStatus.OK)
    public List<Course> getCoursesByCategory(@PathVariable("category") String category){
        return courseService.findCoursesByCategory(category);
    }

    @GetMapping("/get-by-topic/{topic}")
    @ResponseStatus(HttpStatus.OK)
    public List<Course> getCoursesByTopic(@PathVariable("topic") String topic){
        return courseService.findCoursesByTopic(topic);
    }

    @GetMapping("/get-by-rating")
    @ResponseStatus(HttpStatus.OK)
    public List<Course> getCoursesByRating(@RequestParam double minRating,
                                           @RequestParam double maxRating){
        return courseService.findCourseByRating(minRating, maxRating);
    }

    @PostMapping("/create/{teacherId}")
    public ResponseEntity<String> createCourse(@PathVariable("teacherId") Long teacherId,
                                               @RequestBody Course course){
        courseService.createCourse(teacherId, course);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Teacher " + teacherId + " has successfully created course "
                        + course.getCourseId());
    }

    @DeleteMapping("/delete/{teacherId}/{courseId}")
    public ResponseEntity<String> deleteCourse(@PathVariable("teacherId") Long teacherId,
                                               @PathVariable("courseId")Long courseId){
        courseService.deleteCourse(teacherId, courseId);
        return ResponseEntity.status(HttpStatus.OK)
                .body("Teacher " + teacherId + " has successfully deleted course "
                        + courseId);
    }

    @GetMapping("/get-course-in-cart/{studentId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Course> getCoursesInCartByStudentId(@PathVariable("studentId") Long studentId){
        return courseService.findCoursesInCartByStudentId(studentId);
    }

    @GetMapping("/get-total-price-earned/{teacherId}")
    @ResponseStatus(HttpStatus.OK)
    public double getTotalPriceEarned(@PathVariable("teacherId") Long teacherId){
        return courseService.findTotalPriceEarned(teacherId);
    }
}
