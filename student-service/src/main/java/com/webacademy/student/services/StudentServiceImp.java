package com.webacademy.student.services;

import com.webacademy.common.entities.Student;
import com.webacademy.common.repositories.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class StudentServiceImp implements StudentService {


    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Student findStudentByEmailId(String email) {
        return studentRepository.findStudentByEmailId(email);
    }

    @Override
    public void addNewStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void deleteStudentByEmailId(String email) {
        Student student = studentRepository.findStudentByEmailId(email);

        studentRepository.deleteById(student.getStudentId());

    }
}
