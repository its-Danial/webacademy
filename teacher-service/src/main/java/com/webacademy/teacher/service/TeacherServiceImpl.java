package com.webacademy.teacher.service;

import com.webacademy.common.entities.*;
import com.webacademy.teacher.repository.TeacherRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service("teacherService")
@Transactional
@Slf4j
public class TeacherServiceImpl implements TeacherService{

    @Autowired
    TeacherRepository teacherRepository;

    @Override
    public List<Teacher> findAllTeacher() {
        log.info("Fetch all teachers");
        return teacherRepository.findAll();
    }

    @Override
    public Optional<Teacher> findTeacherById(Long id) {
        if(!teacherRepository.existsByTeacherId(id)){
            throw new IllegalStateException("No teacher found by id: " + id);
        }
        log.info("Fetch teacher {}", id);
        return teacherRepository.findById(id);
    }

    @Override
    public Teacher findTeacherByUsername(String username) {
        if(!teacherRepository.existsByUsername(username)){
            throw new IllegalStateException("No teacher found by username: " + username);
        }

        log.info("Fetch teacher with username: {}", username);
        return teacherRepository.findTeacherByUsername(username);
    }

    @Override
    public Teacher findTeacherByEmail(String email) {
        if(!teacherRepository.existsByEmail(email)){
            throw new IllegalStateException("No teacher found by email: " + email);
        }
        log.info("Teacher with email:{} found", email);
        return teacherRepository.findTeacherByEmail(email);
    }

    @Override
    public Teacher login(String email, String password) {
        if(teacherRepository.existsByEmailAndPassword(email, password)){
            return teacherRepository.findTeacherByEmail(email);
        } else{
            throw new IllegalStateException("Invalid email or password");
        }
    }

    @Override
    public Teacher register(String email, String username, String fullname, String password) {
        Teacher teacher = new Teacher();
        teacher.setEmail(email);
        teacher.setUsername(username);
        teacher.setFullName(fullname);
        teacher.setPassword(password);
        teacherRepository.save(teacher);
        return teacherRepository.findTeacherByUsername(username);
    }

    @Override
    public void addTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
        log.info("Added teacher {}", teacher.getUsername());
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
        log.info("Updated teacher {}", teacher.getUsername());
    }

    @Override
    public void deleteTeacherByEmail(String email) {
        Teacher teacher = teacherRepository.findTeacherByEmail(email);
        log.info("Deleted teacher {}", teacher.getUsername());
        teacherRepository.deleteById(teacher.getTeacherId());
    }

}
