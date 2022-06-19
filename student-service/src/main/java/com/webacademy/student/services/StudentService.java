package com.webacademy.student.services;

import com.webacademy.student.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudent();

    Student findStudentByEmailId(String email);

    void addNewStudent(Student student);

    void deleteStudentByEmailId(String email);


}
