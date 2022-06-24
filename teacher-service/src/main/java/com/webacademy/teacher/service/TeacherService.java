package com.webacademy.teacher.service;

import com.webacademy.common.entities.Student;
import com.webacademy.common.entities.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> getAllTeacher();

    Teacher findTeacherByEmail(String email);

    void addTeacher(Teacher teacher);

    void updateTeacher(Teacher teacher);

    void deleteTeacherByEmail(String email);
}
