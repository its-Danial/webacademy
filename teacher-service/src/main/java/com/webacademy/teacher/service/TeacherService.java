package com.webacademy.teacher.service;

import com.webacademy.common.entities.Teacher;

import java.util.List;
import java.util.Optional;

public interface TeacherService {
    List<Teacher> findAllTeacher();

    Optional<Teacher> findTeacherById(Long id);

    Teacher findTeacherByEmail(String email);

    Teacher findTeacherByUsername(String username);

    Teacher login(String email, String password);

    void addTeacher(Teacher teacher);

    void updateTeacher(String email, String newEmail,
                       String newUsername, String newFullname);

    void deleteTeacherById(Long id);

    Teacher register(String email, String username, String fullname, String password);

    Teacher editProfile(Long teacherId, String bio, String avatarUrl);
}
