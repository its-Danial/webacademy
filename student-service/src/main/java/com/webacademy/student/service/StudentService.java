package com.webacademy.student.service;

import com.webacademy.common.entities.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    List<Student> findAllStudent();

    Student findStudentByEmail(String email);

    Student findStudentByUsername(String username);

    void addStudent(Student student);

    void updateStudent(Student student);

    void deleteStudentByEmailId(String email);

    Optional<Student> findStudentById(Long id);

    List<Student> findStudentsByCourseId(Long id);

    Student findStudentByCourseIdAndStudentId(Long courseId, Long studentId);

    Student login(String username, String password);

    Student register(String email, String username, String fullname, String password);
}
