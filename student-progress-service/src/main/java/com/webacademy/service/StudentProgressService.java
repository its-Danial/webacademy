package com.webacademy.service;

import com.webacademy.common.entities.StudentProgress;

import java.util.List;

public interface StudentProgressService {

    List<StudentProgress> findAllStudentProgress();

    List<StudentProgress> findProgressesByStudentId(Long studentId);

    List<StudentProgress> findProgressesByCourseId(Long courseId);

    void updateCompletedByOne(Long studentId, Long courseId);

    StudentProgress findProgressByStudentIdAndCourseId(Long studentId, Long courseId);

    void likeCourse(Long studentId, Long courseId);

    void unlikeCourse(Long studentId, Long courseId);

    void insertProgressByStudentIdAndCourseId(Long studentId, Long courseId);

    void updateTotalLectures(Long courseId);

    void deleteProgressesByCourseId(Long courseId);

    void deleteProgressesByStudentId(Long studentId);
}
