package com.webacademy.teacher.service;

import com.webacademy.common.entities.Category;
import com.webacademy.common.entities.CourseInformation;
import com.webacademy.common.entities.Teacher;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface TeacherService {
    List<Teacher> findAllTeacher();

    Optional<Teacher> findTeacherById(Long id);

    Teacher findTeacherByEmail(String email);

    void addTeacher(Teacher teacher);

    void updateTeacher(Teacher teacher);

    void deleteTeacherByEmail(String email);


}
