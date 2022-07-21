package com.webacademy.course_lecture.service;


import com.webacademy.common.entities.Course;
import com.webacademy.common.entities.CourseLecture;
import com.webacademy.course_lecture.feign.CourseFeignClient;
import com.webacademy.course_lecture.feign.ProgressFeignClient;
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
    TeacherFeignClient teacherFeignClient;

    @Autowired
    ProgressFeignClient progressFeignClient;

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

    @Override
    public void addLecture(Long teacherId, Long courseId, CourseLecture courseLecture) {
        Course course = courseFeignClient.getCourseByCourseId(courseId).
                orElseThrow(()-> new IllegalStateException("Course not found"));

        if(!teacherId.equals(course.getTeacher().getTeacherId())){
            log.error("The teacher doesn't own the course");
            throw new IllegalStateException("The teacher doesn't own the course");
        } else{
            courseLecture.setCourse(course);
            courseLectureRepository.save(courseLecture);
            log.info("Teacher {} has added a lecture in course {}",teacherId, courseId);
        }

    }

    @Override
    public void addMultipleLectures(Long teacherId, Long courseId, List<CourseLecture> courseLectures){
        Course course = courseFeignClient.getCourseByCourseId(courseId).
                orElseThrow(()-> new IllegalStateException("Course not found"));

        if(!teacherId.equals(course.getTeacher().getTeacherId())){
            log.error("The teacher doesn't own the course");
            throw new IllegalStateException("The teacher doesn't own the course");
        } else{
            for (CourseLecture lecture:courseLectures) {
                lecture.setCourse(course);
                courseLectureRepository.save(lecture);

                log.info("Teacher {} has added a lecture {} in course {}",
                        teacherId, lecture.getCourseLectureId(), courseId);

            }
        }

    }

    @Override
    public void updateLecture(Long teacherId, Long courseId, Long lectureId, CourseLecture newLecture) {
        Course course = courseFeignClient.getCourseByCourseId(courseId).
                orElseThrow(()-> new IllegalStateException("Course not found"));
        CourseLecture currentLecture = courseLectureRepository.findCourseLectureById(lectureId)
                        .orElseThrow(()-> new IllegalStateException("Lecture not found"));

        if(!teacherId.equals(course.getTeacher().getTeacherId())){
            log.error("The teacher doesn't own the course");
            throw new IllegalStateException("The teacher doesn't own the course");
        } else{
            currentLecture.setTitle(newLecture.getTitle());
            currentLecture.setCourseLectureDescription(newLecture.getCourseLectureDescription());
            currentLecture.setLectureDuration(newLecture.getLectureDuration());
            currentLecture.setLectureUrl(newLecture.getLectureUrl());
            courseLectureRepository.save(currentLecture);
        }
    }

    @Override
    public void deleteLecture(Long teacherId, Long courseId, Long lectureId) {
        Course course = courseFeignClient.getCourseByCourseId(courseId).
                orElseThrow(() -> new IllegalStateException("Course not found"));
        CourseLecture lecture = courseLectureRepository.findCourseLectureById(lectureId).
                orElseThrow(() -> new IllegalStateException("Lecture not found"));


        if (!teacherId.equals(course.getTeacher().getTeacherId())) {
            log.error("The teacher doesn't own the course");
            throw new IllegalStateException("The teacher doesn't own the course");
        }
        //Check if the course has the specified lecture
        if(!courseId.equals(lecture.getCourse().getCourseId())){
            log.error("The lecture doesn't belong to the course");
            throw new IllegalStateException("The lecture doesn't belong to the course");
        }

        progressFeignClient.deleteProgressesByCourseId(courseId);
        courseLectureRepository.deleteById(lectureId);
        log.info("Teacher {} has deleted lecture {}", teacherId, lectureId);
    }

}
