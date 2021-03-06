package com.webacademy.student.service;

import com.webacademy.common.entities.Student;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface StudentService {

    List<Student> findAllStudent();

    Student findStudentByEmail(String email);

    Student findStudentByUsername(String username);

    void addStudent(Student student);

    void deleteStudentById(Long id);

    Optional<Student> findStudentById(Long id);

    List<Student> findStudentsByCourseId(Long id);

    Student findStudentByCourseIdAndStudentId(Long courseId, Long studentId);

    Student login(String email, String password);

    Student register(String email, String username, String fullname, String password);

    Set<Student> findStudentsByTeacherId(Long teacherId);

    List<Student> searchStudentByEmailKeyword(String email);
}
