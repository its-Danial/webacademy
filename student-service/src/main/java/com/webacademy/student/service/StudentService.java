package com.webacademy.student.service;

import com.webacademy.common.entities.Student;

import java.util.List;

public interface StudentService {

    List<Student> findAllStudent();

    Student findStudentByEmail(String email);

    void addStudent(Student student);

    void updateStudent(Student student);

    void deleteStudentByEmailId(String email);


}
