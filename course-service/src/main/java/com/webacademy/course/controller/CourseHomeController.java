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

//    @GetMapping("/getAll")
//    public List<Object> getAllCourseWithoutStudent() {
//        return courseService.findAllCourseWithoutStudent();
//    }

    @GetMapping("/filter")
    @ResponseStatus(HttpStatus.OK)
    public List<Course> getCoursesByPage(@RequestParam int page, @RequestParam int size){
        return courseService.findCoursesByPage(page, size);
    }

    @GetMapping("/getById/{courseId}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Course> getCourseByCourseId(@PathVariable("courseId") Long id){
        return courseService.findCourseByCourseId(id);
    }

    @GetMapping("/getByTeacherId/{teacherId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Course> getCoursesByTeacherId(@PathVariable("teacherId") Long id){
        return courseService.findCoursesByTeacherId(id);
    }

    @GetMapping("/getByStudentId/{studentId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Course> getCoursesByStudentId(@PathVariable("studentId") Long id){
        return courseService.findCoursesByStudentId(id);
    }

    @GetMapping("/getByCategory/{category}")
    @ResponseStatus(HttpStatus.OK)
    public List<Course> getCoursesByCategory(@PathVariable("category") String category){
        return courseService.findCoursesByCategory(category);
    }

    @GetMapping("/getByTopic/{topic}")
    @ResponseStatus(HttpStatus.OK)
    public List<Course> getCoursesByTopic(@PathVariable("topic") String topic){
        return courseService.findCoursesByTopic(topic);
    }

    @GetMapping("/getByRating")
    @ResponseStatus(HttpStatus.OK)
    public List<Course> getCoursesByRating(@RequestParam double minRating, @RequestParam double maxRating){
        return courseService.findCourseByRating(minRating, maxRating);
    }

    @PutMapping("/updateProgress/{courseId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateProgress(@PathVariable("courseId") Long id){
        Course course = courseService.findCourseByCourseId(id).orElse(null);
        courseService.updateProgress(course);
    }

    @PostMapping("/create/{teacherId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void createCourse(@PathVariable("teacherId") Long teacherId, @RequestBody Course course){
        courseService.createCourse(teacherId, course);
    }

    @DeleteMapping("/delete/{courseId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCourse(@PathVariable("courseId")Long courseId){
        courseService.deleteCourse(courseId);
    }
}
