package com.webacademy.course_lecture.service;


import com.webacademy.common.entities.CourseLecture;
import com.webacademy.common.entities.Student;
import com.webacademy.course_lecture.feign.StudentFeignClient;
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
    StudentFeignClient studentFeignClient;

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

    //TODO: set completed progress only for a specific student

    /* Find ONE student by courseid,
     *
    */
    @Override
    public void setCompletedProgress(CourseLecture courseLecture) {
        courseLecture.setCompleted(true);
        log.info("Lecture {} is completed", courseLecture.getTitle());
    }

}
