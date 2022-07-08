package com.webacademy.course.service;

import com.webacademy.common.entities.*;
import com.webacademy.course.feign.LectureFeignClient;
import com.webacademy.course.feign.TeacherFeignClient;
import com.webacademy.course.repository.CourseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service("courseService")
@Transactional
@Slf4j
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;
    @Autowired
    LectureFeignClient lectureFeignClient;

    @Autowired
    TeacherFeignClient teacherFeignClient;

    @Override
    public String hello() {
        return "hello";
    }

    @Override
    public List<Course> findAllCourse() {
        log.info("Fetch all courses");
        return courseRepository.findAll();
    }

//    @Override
//    public List<Object> findAllCourseWithoutStudent() {
//        log.info("Fetch all courses without students");
//        return courseRepository.findAllCourseWithoutStudent();
//    }

    //Handles Pagination
    @Override
    public List<Course> findCoursesByPage(int page, int size) {
        Page<Course> pages = courseRepository.findAll(PageRequest.of(page, size));
        return pages.getContent();
    }

    @Override
    public List<Course> findCoursesByTeacherId(Long id) {
        log.info("Fetch courses by teacher: {}", id);
        return courseRepository.findCoursesByTeacherId(id);
    }

    @Override
    public List<Course> findCoursesByCategory(String category) {
        log.info("Fetch courses by category: {}", category);
        return courseRepository.findCoursesByCategory(category);
    }

    @Override
    public List<Course> findCoursesByTopic(String topic) {
        log.info("Fetch courses by topic: {}", topic);
        return courseRepository.findCoursesByTopic(topic);
    }

    @Override
    public List<Course> findCourseByRating(double minRating, double maxRating) {
        log.info("Fetch course by rating between min:{} and max:{}", minRating, maxRating);
        return courseRepository.findCourseByRating(minRating, maxRating);
    }

    @Override
    public Optional<Course> findCourseByCourseId(Long id) {
        log.info("Fetch course {}", id);
        return courseRepository.findById(id);
    }

    @Override
    public List<Course> findCoursesByStudentId(Long id) {
        log.info("Fetch courses by student {}", id);
        return courseRepository.findCoursesByStudentId(id);
    }

    @Override
    public void createCourse(Long teacherId, Course course) {
        Teacher teacher = teacherFeignClient.getTeacherById(teacherId).
                orElseThrow(()-> new IllegalArgumentException("Teacher not found"));

        course.setTeacher(teacher);
        courseRepository.save(course);
        log.info("Teacher {} added course {}", teacher.getFullName(), course.getTitle());
    }

    @Override
    public void deleteCourse(Long teacherId, Long courseId) {
        Course course = courseRepository.findById(courseId).
                orElseThrow(()-> new IllegalArgumentException("Course not found"));

        if (!teacherId.equals(course.getTeacher().getTeacherId())) {
            log.error("The teacher doesn't own the course");
            throw new IllegalStateException("The teacher doesn't own the course");
        }
        courseRepository.deleteById(courseId);
        log.info("Teacher {} has deleted course {}", teacherId, courseId);
    }

    @Override
    public List<Course> findCoursesInCartByStudentId(Long studentId) {
        log.info("Fetch courses in cart by student {}", studentId);
        return courseRepository.findCoursesInCartByStudentId(studentId);
    }

    @Override
    public int countBoughtCourseByCourseId(Long courseId) {
        int count = courseRepository.countBoughtCourseByCourseId(courseId);
        log.info("Course {} has been bought {} times", courseId, count);
        return count;
    }
}
