package com.webacademy.teacher.service;

import com.webacademy.common.entities.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> findAllTeacher();

    Teacher findTeacherByEmail(String email);

    void addTeacher(Teacher teacher);

    void updateTeacher(Teacher teacher);

    void deleteTeacherByEmail(String email);
}
