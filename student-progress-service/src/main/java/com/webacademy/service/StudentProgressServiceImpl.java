package com.webacademy.service;

import com.webacademy.common.entities.StudentProgress;
import com.webacademy.repository.StudentProgressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service

public class StudentProgressServiceImpl implements StudentProgressService {

    @Autowired
    StudentProgressRepository studentProgressRepository;

    @Override
    public List<StudentProgress> getAllStudentProgress() {
        return studentProgressRepository.findAll();
    }

    @Override
    @Transactional
    public HttpStatus updateCompletedByOne(Long studentId, Long courseId) {
        StudentProgress studentProgress = studentProgressRepository
                .findStudentProgressByStudentIdAndCourseId(studentId, courseId);

        if (studentProgress.getCompletedLectures() + 1 <= studentProgress.getTotalLectures()) {
            studentProgress.setCompletedLectures(studentProgress.getCompletedLectures() + 1);
            return HttpStatus.CREATED;
        } else {
            throw new IllegalStateException("Completed progress cannot be more than total number of lectures");
        }

    }

    @Override
    public StudentProgress getOneByStudentIdAndCourseId(Long studentId, Long courseId) {
        return studentProgressRepository.findStudentProgressByStudentIdAndCourseId(studentId, courseId);
    }
}
