package com.webacademy.service;

import com.webacademy.common.entities.StudentProgress;
import com.webacademy.repository.StudentProgressRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("studentProgressService")
@Slf4j
public class StudentProgressServiceImpl implements StudentProgressService {

    @Autowired
    StudentProgressRepository studentProgressRepository;

    @Override
    public List<StudentProgress> findAllStudentProgress() {
        log.info("Fetch all student progresses");
        return studentProgressRepository.findAll();
    }

    @Override
    public List<StudentProgress> findProgressesByStudentId(Long studentId) {
        log.info("Fetch student {}'s progresses", studentId);
        return studentProgressRepository.findProgressesByStudentId(studentId);
    }

    @Override
    @Transactional
    public void updateCompletedByOne(Long studentId, Long courseId) {
        StudentProgress studentProgress = studentProgressRepository
                .findProgressByStudentIdAndCourseId(studentId, courseId);
        log.info("Student's progress BEFORE: {}", studentProgress.getCompletedLectures());

        if (studentProgress.getCompletedLectures() + 1 <= studentProgress.getTotalLectures()) {
            studentProgress.setCompletedLectures(studentProgress.getCompletedLectures() + 1);
            log.info("Student's progress AFTER: {}", studentProgress.getCompletedLectures());
        } else {
            throw new IllegalStateException("Completed progress cannot be more than total number of lectures");
        }
    }

    @Override
    public StudentProgress findProgressByStudentIdAndCourseId(Long studentId, Long courseId) {
        if(studentId == null || courseId == null ){
            throw new IllegalStateException("No studentId or courseId inserted");
        }
        log.info("Fetch progress by student {} and course {}", studentId, courseId);
        return studentProgressRepository.findProgressByStudentIdAndCourseId(studentId, courseId);
    }

    @Override
    @Transactional
    public void likeCourse(Long studentId, Long courseId) {
        StudentProgress studentProgress = studentProgressRepository
                .findProgressByStudentIdAndCourseId(studentId, courseId);

        studentProgress.setLiked(true);
        log.info("Student {} liked course {}", studentId, courseId);
    }

    @Override
    @Transactional
    public void unlikeCourse(Long studentId, Long courseId) {
        StudentProgress studentProgress = studentProgressRepository
                .findProgressByStudentIdAndCourseId(studentId, courseId);

        studentProgress.setLiked(false);
        log.info("Student {} unliked course {}", studentId, courseId);
    }


}
