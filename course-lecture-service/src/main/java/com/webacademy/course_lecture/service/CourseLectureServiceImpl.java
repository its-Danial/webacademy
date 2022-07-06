package com.webacademy.course_lecture.service;


import com.webacademy.common.entities.Course;
import com.webacademy.common.entities.CourseLecture;
import com.webacademy.common.entities.Student;
import com.webacademy.common.entities.Teacher;
import com.webacademy.course_lecture.feign.CourseFeignClient;
import com.webacademy.course_lecture.feign.StudentFeignClient;
import com.webacademy.course_lecture.feign.TeacherFeignClient;
import com.webacademy.course_lecture.repository.CourseLectureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service("courseLectureService")
@Transactional
@Slf4j
public class CourseLectureServiceImpl implements CourseLectureService {

    @Autowired
    CourseLectureRepository courseLectureRepository;

    @Autowired
    CourseFeignClient courseFeignClient;

    @Autowired
    StudentFeignClient studentFeignClient;

    @Autowired
    TeacherFeignClient teacherFeignClient;

    @Override
    public List<CourseLecture> findLecturesByCourseId(Long id) {
        log.info("Fetch lectures in course {}", id);
        return courseLectureRepository.findLecturesByCourseId(id);
    }

    @Override
    public Optional<CourseLecture> findLectureById(Long id) {
        log.info("Fetch lecture {}", id);
        return courseLectureRepository.findCourseLectureById(id);
    }

    //TODO: add Lecture needs testing
    @Override
    public void addLecture(Long teacherId, Long courseId, CourseLecture courseLecture) {
        Course course = courseFeignClient.getCourseByCourseId(courseId).orElse(null);
        if(!teacherId.equals(course.getTeacher().getTeacherId())){
            log.error("The teacher doesn't own the course");
        } else{
            courseLectureRepository.save(courseLecture);
        }


    }

}
