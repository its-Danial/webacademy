package com.webacademy.teacher.service;

import com.webacademy.common.entities.Course;
import com.webacademy.common.entities.Teacher;
import com.webacademy.teacher.feign.CourseFeignClient;
import com.webacademy.teacher.repository.TeacherRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service("teacherService")
@Transactional
@Slf4j
public class TeacherServiceImpl implements TeacherService{

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    CourseFeignClient courseFeignClient;

    @Override
    @CachePut(value = "teachers")
    public List<Teacher> findAllTeacher() {
        log.info("Fetch all teachers");
        return teacherRepository.findAll();
    }

    @Override
    @CachePut(value = "teachers", key = "#id")
    public Optional<Teacher> findTeacherById(Long id) {
        if(!teacherRepository.existsByTeacherId(id)){
            throw new IllegalStateException("No teacher found by id: " + id);
        }
        log.info("Fetch teacher {}", id);
        return teacherRepository.findById(id);
    }

    @Override
    @CachePut(value = "teachers", key = "#username")
    public Teacher findTeacherByUsername(String username) {
        if(!teacherRepository.existsByUsername(username)){
            throw new IllegalStateException("No teacher found by username: " + username);
        }

        log.info("Fetch teacher with username: {}", username);
        return teacherRepository.findTeacherByUsername(username);
    }

    @Override
    @CachePut(value = "teachers", key = "#email")
    public Teacher findTeacherByEmail(String email) {
        if(!teacherRepository.existsByEmail(email)){
            throw new IllegalStateException("No teacher found by email: " + email);
        }
        log.info("Teacher with email:{} found", email);
        return teacherRepository.findTeacherByEmail(email);
    }

    @Override
    @CachePut(value = "teachers", key = "#email")
    public Teacher login(String email, String password) {
        if(teacherRepository.existsByEmailAndPassword(email, password)){
            return teacherRepository.findTeacherByEmail(email);
        } else{
            throw new IllegalStateException("Invalid email or password");
        }
    }

    @Override
    @CachePut(value = "teachers", key = "#email")
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
    public Teacher editProfile(Long teacherId, String bio, String avatarUrl) {
        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(()-> new IllegalStateException("Teacher not found"));
        teacher.setBioText(bio);
        teacher.setAvatarPictureUrl(avatarUrl);
        teacherRepository.save(teacher);
        return teacherRepository.findTeacherByEmail(teacher.getEmail());
    }

    @Override
    public List<Teacher> searchTeacherByEmailKeyword(String email) {
        if(email == null || email.equals("")){
            return teacherRepository.findAll();
        } else{
            log.info("Search teacher by email keyword: {}", email);
            return teacherRepository.findTeachersByEmailContainingIgnoreCase(email);
        }
    }


    @Override
    public void addTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
        log.info("Added teacher {}", teacher.getUsername());
    }

    @Override
    @CachePut(value = "teachers", key = "#email")
    public void updateTeacher(String email, String newEmail,
                              String newUsername, String newFullname) {
        if(teacherRepository.existsByEmail(email)){
            Teacher teacher = teacherRepository.findTeacherByEmail(email);
            teacher.setEmail(newEmail);
            teacher.setUsername(newUsername);
            teacher.setFullName(newFullname);
            teacherRepository.save(teacher);
            log.info("Updated teacher {}", teacher.getUsername());
        } else{
            throw new IllegalStateException("Email doesn't exist");
        }
    }

    @Override
    @CacheEvict(value = "teachers", key = "#id")
    public void deleteTeacherById(Long id) {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(()-> new IllegalStateException("Teacher not found"));
        //Delete courses that the teacher has
        List<Course> courses = courseFeignClient.getCoursesByTeacherId(teacher.getTeacherId());
        for (Course course : courses) {
            courseFeignClient.deleteCourse(teacher.getTeacherId(), course.getCourseId());
        }
        teacherRepository.deleteById(id);
        log.info("Deleted teacher {}", teacher.getUsername());
    }

}
