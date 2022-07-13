package com.webacademy.service;

import com.webacademy.common.entities.Course;
import com.webacademy.common.entities.CourseLecture;
import com.webacademy.common.entities.Student;
import com.webacademy.common.entities.StudentProgress;
import com.webacademy.feign.CourseFeignClient;
import com.webacademy.feign.LectureFeignClient;
import com.webacademy.feign.StudentFeignClient;
import com.webacademy.repository.StudentProgressRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("studentProgressService")
@Slf4j
public class StudentProgressServiceImpl implements StudentProgressService {

    @Autowired
    StudentProgressRepository studentProgressRepository;

    @Autowired
    StudentFeignClient studentFeignClient;
    @Autowired
    CourseFeignClient courseFeignClient;
    @Autowired
    LectureFeignClient lectureFeignClient;

    @Override
    public List<StudentProgress> findAllStudentProgress() {
        log.info("Fetch all student progresses");
        return studentProgressRepository.findAll();
    }

    @Override
    public List<StudentProgress> findProgressesByStudentId(Long studentId) {
        log.info("Fetch progresses by student {}", studentId);
        return studentProgressRepository.findProgressesByStudentId(studentId);
    }

    @Override
    public List<StudentProgress> findProgressesByCourseId(Long courseId) {
        log.info("Fetch progresses by course {}", courseId);
        return studentProgressRepository.findProgressesByCourseId(courseId);
    }

    @Override
    @Transactional
    public void updateCompletedByOne(Long studentId, Long courseId) {
        StudentProgress studentProgress = studentProgressRepository
                .findProgressByStudentIdAndCourseId(studentId, courseId);
        log.info("Student's progress BEFORE: {}", studentProgress.getCompletedLectures());

        if (studentProgress.getCompletedLectures() + 1 <= studentProgress.getTotalLectures()) {
            studentProgress.setCompletedLectures(studentProgress.getCompletedLectures() + 1);
            log.info("Student's progress AFTER: {}", studentProgress.getCompletedLectures());
        } else {
            throw new IllegalStateException("Completed progress cannot be more than total number of lectures");
        }
    }

    @Override
    public StudentProgress findProgressByStudentIdAndCourseId(Long studentId, Long courseId) {
        if(studentId == null || courseId == null ){
            throw new IllegalStateException("No studentId or courseId inserted");
        }
        log.info("Fetch progress by student {} and course {}", studentId, courseId);
        return studentProgressRepository.findProgressByStudentIdAndCourseId(studentId, courseId);
    }

    @Override
    @Transactional
    public void likeCourse(Long studentId, Long courseId) {
        StudentProgress studentProgress = studentProgressRepository
                .findProgressByStudentIdAndCourseId(studentId, courseId);
        if(studentProgress.isLiked()){
            throw new IllegalStateException("Student " + studentId + " already liked the course");
        }
        studentProgress.setLiked(true);
        log.info("Student {} liked course {}", studentId, courseId);
    }

    @Override
    @Transactional
    public void unlikeCourse(Long studentId, Long courseId) {
        StudentProgress studentProgress = studentProgressRepository
                .findProgressByStudentIdAndCourseId(studentId, courseId);
        if(!studentProgress.isLiked()){
            throw new IllegalStateException("Student " + studentId +
                    " hasn't liked the course. You can't unlike it");
        }

        studentProgress.setLiked(false);
        log.info("Student {} unliked course {}", studentId, courseId);
    }

    @Override
    @Transactional
    public void insertProgressByStudentIdAndCourseId(Long studentId, Long courseId) {
        Student student = studentFeignClient.getStudentById(studentId).
                orElseThrow(()-> new IllegalArgumentException("Student not found"));
        Course course = courseFeignClient.getCourseByCourseId(courseId).
        orElseThrow(()-> new IllegalArgumentException("Course not found"));

        //progress insertion
        StudentProgress studentProgress = new StudentProgress();
        studentProgress.setStudent(student);
        studentProgress.setCourse(course);
        List<CourseLecture> lectures = lectureFeignClient.getLecturesByCourse(course.getCourseId());
        studentProgress.setTotalLectures(lectures.size());
        studentProgressRepository.save(studentProgress);

        log.info("Inserted student {}'s progress to course {}", studentId, courseId);
    }

    @Override
    @Transactional
    public void updateTotalLectures(Long courseId) {
        List<StudentProgress> progresses = studentProgressRepository.findProgressesByCourseId(courseId);
        List<CourseLecture> lectures = lectureFeignClient.getLecturesByCourse(courseId);
        log.info("Lecture size = {}", lectures.size());
        for (StudentProgress progress : progresses) {
            progress.setTotalLectures(lectures.size());
            studentProgressRepository.save(progress);
            log.info("Total Lecture in progress = {}", progress.getTotalLectures());
        }
    }

    @Override
    public void deleteProgressesByCourseId(Long courseId) {
        List<StudentProgress> progresses = studentProgressRepository.findProgressesByCourseId(courseId);

        for(StudentProgress progress : progresses){
            studentProgressRepository.deleteById(progress.getStudentProgressId());
            log.info("Deleted progress {}", progress.getStudentProgressId());
        }
    }


}
