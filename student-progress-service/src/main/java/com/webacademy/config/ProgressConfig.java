package com.webacademy.config;

import com.webacademy.common.entities.Course;
import com.webacademy.common.entities.CourseLecture;
import com.webacademy.common.entities.Student;
import com.webacademy.common.entities.StudentProgress;
import com.webacademy.feign.CourseFeignClient;
import com.webacademy.feign.LectureFeignClient;
import com.webacademy.feign.StudentFeignClient;
import com.webacademy.repository.StudentProgressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ProgressConfig {


    @Autowired
    CourseFeignClient courseFeignClient;

    @Autowired
    StudentFeignClient studentFeignClient;

    @Autowired
    LectureFeignClient lectureFeignClient;

    @Bean
    CommandLineRunner commandLineRunner(StudentProgressRepository studentProgressRepository) {
        return args -> {


            Student student = studentFeignClient.getStudentById(1L)
                    .get();

//            Course course = courseFeignClient.getCourseByCourseId(1L)
//                    .get();


            Course course2 = courseFeignClient.getCourseByCourseId(2L)
                    .get();


            List<CourseLecture> lectures = lectureFeignClient.getLecturesByCourse(course2.getCourseId());


//            StudentProgress studentProgress = StudentProgress.builder()
//                    .student(student)
//                    .totalLectures(lectures.size())
//                    .completedLectures(0)
//                    .course(course)
//                    .build();


            StudentProgress studentProgress2 = StudentProgress.builder()
                    .student(student)
                    .totalLectures(lectures.size())
                    .completedLectures(0)
                    .course(course2)
                    .build();


            studentProgressRepository.save(studentProgress2);

        };

    }

}
