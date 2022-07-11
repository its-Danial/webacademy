package com.webacademy.student.service;

import com.webacademy.common.entities.Student;
import com.webacademy.student.feign.CartFeignClient;
import com.webacademy.student.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service("studentService")
@Slf4j
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    CartFeignClient cartFeignClient;

    @Override
    @CachePut(value = "students")
    public List<Student> findAllStudent() {
        log.info("Fetch all students");
        return studentRepository.findAll();
    }

    @Override
    @Cacheable(value = "students", key = "@studentRepository.findById(#id).get().email")
    public Optional<Student> findStudentById(Long id) {
        if(!studentRepository.existsByStudentId(id)){
            throw new IllegalStateException("No student found by id: " + id);
        }
        log.info("Fetch student with id: {}", id);
        return studentRepository.findById(id);
    }


    @Override
    @Cacheable(value = "students", key = "#id")
    public List<Student> findStudentsByCourseId(Long id) {

        log.info("Fetch students in course id: {}", id);
        return studentRepository.findStudentsByCourseId(id);
    }

    @Override
    @Cacheable(value = "students", key = "@studentRepository.findById(#studentId).get().email")
    public Student findStudentByCourseIdAndStudentId(Long courseId, Long studentId) {
        log.info("Fetch student id: {} in course id: {}", studentId, courseId);
        return studentRepository.findStudentByCourseIdAndStudentId(courseId, studentId);
    }

    @Override
    @Cacheable(value= "students", key = "#email")
    public Student login(String email, String password) {

        if(studentRepository.existsByEmailAndPassword(email, password)){
            Student student = studentRepository.findStudentByEmail(email);
            log.info("Student {} logged in", student.getStudentId());
            return student;
        } else{
            throw new IllegalStateException("Invalid email or password");
        }
    }

    @Override
    @CachePut(value= "students", key = "#email")
    public Student register(String email, String username, String fullname, String password) {
            Student student = new Student();
            student.setEmail(email);
            student.setUsername(username);
            student.setFullName(fullname);
            student.setPassword(password);
            studentRepository.save(student);
            log.info("Student {} has successfully registered", student.getStudentId());

            //Create cart after student logs in
            cartFeignClient.createCart(student.getStudentId());
            log.info("Cart {} created", student.getStudentId());
            return studentRepository.findStudentByEmail(email);
    }

    @Override
    @Cacheable(value = "students", key = "#email")
    public Student findStudentByEmail(String email) {
        if(!studentRepository.existsByEmail(email)){
            throw new IllegalStateException("No student found by email: " + email);
        }

        log.info("Fetch student with email: {}", email);
        return studentRepository.findStudentByEmail(email);
    }

    @Override
    @Cacheable(value = "students", key = "#username")
    public Student findStudentByUsername(String username) {
        if(!studentRepository.existsByUsername(username)){
            throw new IllegalStateException("No student found by username: " + username);
        }

        log.info("Fetch student with username: {}", username);
        return studentRepository.findStudentByUsername(username);
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
