package com.webacademy.course_lecture.service;

import com.webacademy.common.entities.Course;
import com.webacademy.common.entities.CourseLecture;

import java.util.List;
import java.util.Optional;

public interface CourseLectureService {

    List<CourseLecture> findLecturesByCourseId(Long id);

    Optional<CourseLecture> findLectureById(Long id);

    void addLecture(Long teacherId, Long courseId, CourseLecture courseLecture);

    void addMultipleLectures(Long teacherId, Long courseId, List<CourseLecture> courseLectures);

    void deleteLecture(Long teacherId, Long courseId, Long lectureId);
}
