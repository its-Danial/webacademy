package com.webacademy.service;

import com.webacademy.common.entities.StudentProgress;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentProgressService {

    List<StudentProgress> getAllStudentProgress();

    HttpStatus updateCompletedByOne(Long studentId, Long courseId);

    StudentProgress getOneByStudentIdAndCourseId(Long studentId, Long courseId);
}
