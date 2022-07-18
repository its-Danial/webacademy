package com.webacademy.course.controller;

import com.webacademy.common.entities.Course;
import com.webacademy.common.entities.CourseInformation;
import com.webacademy.course.service.CourseServiceImpl;
import com.webacademy.model.TeacherEarning;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/course")
@CrossOrigin
public class CourseHomeController {

    @Autowired
    CourseServiceImpl courseService;

    @GetMapping("/get-all")
    public List<Course> getAllCourse() {
        return courseService.findAllCourse();
    }

    @GetMapping("/filter")
    public ResponseEntity<List<Course>> getCoursesByCategoryOrTopicPagination(@RequestParam(required = false) String categoryName,
                                                                              @RequestParam(required = false) String topic,
                                                                              @RequestParam(required = false) Double minRating,
                                                                              @RequestParam(required = false) Double maxRating,
                                                                              @RequestParam(defaultValue = "0") int page,
                                                                              @RequestParam(defaultValue = "5", required = false) int size) {
        try {
            if (categoryName != null && minRating != null && maxRating != null) {
                return ResponseEntity.status(HttpStatus.OK)
                        .body(courseService.paginationByCategoryAndRating(categoryName, minRating, maxRating, page));
            } else if (topic != null && minRating != null && maxRating != null) {
                return ResponseEntity.status(HttpStatus.OK)
                        .body(courseService.paginationByTopicAndRating(topic, minRating, maxRating, page));
            } else if (categoryName != null) {
                return ResponseEntity.status(HttpStatus.OK)
                        .body(courseService.paginationByCategory(categoryName, page));
            } else if (topic != null) {
                return ResponseEntity.status(HttpStatus.OK)
                        .body(courseService.paginationByTopic(topic, page));
            } else {
                return ResponseEntity.status(HttpStatus.OK)
                        .body(courseService.findCoursesByPage(page, size));
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Please check your input");
        }
    }

    @GetMapping("/get-by-id/{courseId}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Course> getCourseByCourseId(@PathVariable("courseId") Long id) {
        return courseService.findCourseByCourseId(id);
    }

    @GetMapping("/get-by-teacher-id/{teacherId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Course> getCoursesByTeacherId(@PathVariable("teacherId") Long id) {
        try {
            return courseService.findCoursesByTeacherId(id);
        } catch (Exception e) {
            return new ArrayList<>();
        }

    }

    @GetMapping("/get-by-student-id/{studentId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Course> getCoursesByStudentId(@PathVariable("studentId") Long id) {
        return courseService.findCoursesByStudentId(id);
    }

    @GetMapping("/get-by-category/{category}")
    @ResponseStatus(HttpStatus.OK)
    public List<Course> getCoursesByCategory(@PathVariable("category") String category) {
        return courseService.findCoursesByCategory(category);
    }

    @GetMapping("/get-by-topic/{topic}")
    @ResponseStatus(HttpStatus.OK)
    public List<Course> getCoursesByTopic(@PathVariable("topic") String topic) {
        return courseService.findCoursesByTopic(topic);
    }

    @GetMapping("/get-by-rating")
    @ResponseStatus(HttpStatus.OK)
    public List<Course> getCoursesByRating(@RequestParam double minRating,
                                           @RequestParam double maxRating) {
        return courseService.findCourseByRating(minRating, maxRating);
    }

    @PostMapping("/create/{teacherId}")
    public ResponseEntity<Course> createCourse(@PathVariable("teacherId") Long teacherId,
                                               @RequestBody Course course) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(courseService.createCourse(teacherId, course));
    }

    @PutMapping("/manage/{courseId}")
    public ResponseEntity<String> manageCourseInformation(@PathVariable("courseId") Long courseId,
                                                          @RequestBody CourseInformation courseInformation) {
        courseService.editCourseInformation(courseId, courseInformation);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Updated course " + courseId + "'s information");
    }

    @DeleteMapping("/delete/{teacherId}/{courseId}")
    public ResponseEntity<String> deleteCourse(@PathVariable("teacherId") Long teacherId,
                                               @PathVariable("courseId") Long courseId) {
        courseService.deleteCourse(teacherId, courseId);
        return ResponseEntity.status(HttpStatus.OK)
                .body("Teacher " + teacherId + " has successfully deleted course "
                        + courseId);
    }

    @GetMapping("/get-course-in-cart/{studentId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Course> getCoursesInCartByStudentId(@PathVariable("studentId") Long studentId) {
        return courseService.findCoursesInCartByStudentId(studentId);
    }

    @GetMapping("/get-total-price-earned/{teacherId}")
    @ResponseStatus(HttpStatus.OK)
    public double getTotalPriceEarned(@PathVariable("teacherId") Long teacherId) {
        return courseService.findTotalPriceEarned(teacherId);
    }

    @GetMapping("/get-total-earning-per-course/{teacherId}")
    public List<TeacherEarning> getTotalEarningPerCourse(@PathVariable("teacherId") Long teacherId) {
        return courseService.findTotalEarningPerCourse(teacherId);
    }

    @DeleteMapping("/delete-all-student-course/{studentId}")
    public ResponseEntity<String> deleteAllStudentCourse(@PathVariable("studentId")Long studentId) {
        courseService.deleteAllStudentCourse(studentId);
        return ResponseEntity.status(HttpStatus.OK)
                .body("Deleted all courses from student " + studentId);
    }

    @DeleteMapping("/delete-student-course/{studentId}/{courseId}")
    public ResponseEntity<String> deleteStudentCourse(@PathVariable("studentId")Long studentId,
                                                      @PathVariable("courseId") Long courseId){
        courseService.deleteStudentCourse(studentId, courseId);
        return ResponseEntity.status(HttpStatus.OK)
                .body("Deleted course " + courseId + " from student " + studentId);
    }

    @GetMapping("/search/{title}")
    public List<Course> searchByCourseTitle(@PathVariable("title") String title){
        return courseService.findByCourseTitle(title);
    }
}
