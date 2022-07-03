package com.webacademy.course.service;

import com.webacademy.common.entities.Course;
import com.webacademy.common.entities.CourseLecture;
import com.webacademy.course.feign.LectureFeignClient;
import com.webacademy.course.repository.CourseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    // TODO: make update progress only work for a student
    @Override
    public void updateProgress(Course course) {
        //Gets all lecture in the course
        List<CourseLecture> lectures = lectureFeignClient.getLecturesByCourse(course.getCourseId());
        //Gets size of lecture
        int totalLectures = lectures.size();

        //get number of completed lectures
        double count = 0;
        for (CourseLecture lecture: lectures) {
            if(lecture.isCompleted()){
                count += 1;
            }
        }
        double progress = (count / totalLectures) * 100;
        course.setCompletedProgress(progress);
    }

}
