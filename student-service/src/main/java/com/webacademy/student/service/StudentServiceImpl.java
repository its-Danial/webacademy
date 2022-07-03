package com.webacademy.student.service;

import com.webacademy.common.entities.Student;
import com.webacademy.student.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Optional<Student> findStudentById(Long id) {
        log.info("Fetch student with id: {}", id);
        return studentRepository.findById(id);
    }

    @Override
    public List<Student> findStudentsByCourseId(Long id) {
        log.info("Fetch students in course id: {}", id);
        return studentRepository.findStudentsByCourseId(id);
    }

    @Override
    public Student findStudentByCourseIdAndStudentId(Long courseId, Long studentId) {
        log.info("Fetch student id: {} in course id: {}", studentId, courseId);
        return studentRepository.findStudentByCourseIdAndStudentId(courseId, studentId);
    }

    @Override
    public Student findStudentByEmail(String email) {
        log.info("Fetch student with email: {}", email);
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
