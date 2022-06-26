package com.webacademy.student.service;

import com.webacademy.common.entities.Student;
import com.webacademy.common.repositories.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("studentService")
@Slf4j
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<Student> findAllStudent() {
        log.info("Fetch all students");
        return studentRepository.findAll();
    }

    @Override
    public Student findStudentByEmail(String email) {
        log.info("Student with email: {} found", email);
        return studentRepository.findStudentByEmail(email);
    }

    @Override
    public void addStudent(Student student) {
        studentRepository.save(student);
        log.info("Added student {}", student.getUsername());
    }

    // save() method performs: adding an obejct, and updating existing object.
    // Which is why add and update has the same implementation.
    @Override
    public void updateStudent(Student student) {
        studentRepository.save(student);
        log.info("Updated student {}", student.getUsername());
    }

    @Override
    public void deleteStudentByEmailId(String email) {
        Student student = studentRepository.findStudentByEmail(email);
        log.info("Deleted student {}", student.getUsername());
        studentRepository.deleteById(student.getStudentId());
    }
}
