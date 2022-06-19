package com.webacademy.student.services;

import com.webacademy.student.entity.Student;
import com.webacademy.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
