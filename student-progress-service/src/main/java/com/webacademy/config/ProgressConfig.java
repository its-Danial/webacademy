//package com.webacademy.config;
//
//import com.webacademy.common.entities.Course;
//import com.webacademy.common.entities.CourseLecture;
//import com.webacademy.common.entities.Student;
//import com.webacademy.common.entities.StudentProgress;
//import com.webacademy.feign.CourseFeignClient;
//import com.webacademy.feign.LectureFeignClient;
//import com.webacademy.feign.StudentFeignClient;
//import com.webacademy.repository.StudentProgressRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.List;
//
//@Configuration
//public class ProgressConfig {
//
//
//    @Autowired
//    CourseFeignClient courseFeignClient;
//
//    @Autowired
//    StudentFeignClient studentFeignClient;
//
//    @Autowired
//    LectureFeignClient lectureFeignClient;
//
//    @Bean
//    CommandLineRunner commandLineRunner(StudentProgressRepository studentProgressRepository) {
//        return args -> {
//
//
//            Student student1 = studentFeignClient.getStudentById(1L)
//                    .get();
//            Student student2 = studentFeignClient.getStudentById(2L)
//                    .get();
//            Student student3 = studentFeignClient.getStudentById(3L)
//                    .get();
//            Student student4 = studentFeignClient.getStudentById(4L)
//                    .get();
//
//            Course course1 = courseFeignClient.getCourseByCourseId(1L)
//                    .get();
//            Course course2 = courseFeignClient.getCourseByCourseId(2L)
//                    .get();
//
//            List<CourseLecture> lectures1 = lectureFeignClient.getLecturesByCourse(course1.getCourseId());
//
//            List<CourseLecture> lectures2 = lectureFeignClient.getLecturesByCourse(course2.getCourseId());
//
//            StudentProgress studentProgress1 = StudentProgress.builder()
//                    .student(student1)
//                    .totalLectures(lectures1.size())
//                    .completedLectures(0)
//                    .course(course1)
//                    .build();
//
//            StudentProgress studentProgress2 = StudentProgress.builder()
//                    .student(student2)
//                    .totalLectures(lectures1.size())
//                    .completedLectures(0)
//                    .course(course1)
//                    .build();
//
//            StudentProgress studentProgress3 = StudentProgress.builder()
//                    .student(student3)
//                    .totalLectures(lectures2.size())
//                    .completedLectures(0)
//                    .course(course2)
//                    .build();
//
//            StudentProgress studentProgress4 = StudentProgress.builder()
//                    .student(student4)
//                    .totalLectures(lectures2.size())
//                    .completedLectures(0)
//                    .course(course2)
//                    .build();
//
//            studentProgressRepository.save(studentProgress1);
//            studentProgressRepository.save(studentProgress2);
//            studentProgressRepository.save(studentProgress3);
//            studentProgressRepository.save(studentProgress4);
//
//        };
//
//    }
//
//}
