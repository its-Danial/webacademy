package com.webacademy.teacher.service;

import com.webacademy.common.entities.Student;
import com.webacademy.common.entities.Teacher;
import com.webacademy.common.repositories.TeacherRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("teacherService")
@Slf4j
public class TeacherServiceImpl implements TeacherService{

    @Autowired
    TeacherRepository teacherRepository;

    @Override
    public List<Teacher> getAllTeacher() {
        log.info("Fetch all teachers");
        return teacherRepository.findAll();
    }

    @Override
    public Teacher findTeacherByEmail(String email) {
        log.info("Teacher with email:{} found", email);
        return teacherRepository.findTeacherByEmail(email);
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
