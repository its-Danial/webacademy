package com.webacademy.course_lecture.service;


import com.webacademy.common.entities.CourseLecture;
import com.webacademy.course_lecture.repository.CourseLectureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("courseLectureService")
@Slf4j
public class CourseLectureServiceImpl implements CourseLectureService {

    @Autowired
    CourseLectureRepository courseLectureRepository;

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


}
