//package com.webacademy.course.config;
//
//import com.webacademy.common.entities.Course;
//import com.webacademy.common.entities.CourseInformation;
//import com.webacademy.common.entities.Student;
//import com.webacademy.common.entities.Teacher;
//import com.webacademy.course.repository.CourseRepository;
//import com.webacademy.student.repository.StudentRepository;
//import com.webacademy.teacher.repository.TeacherRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.transaction.Transactional;
//import java.time.LocalDateTime;
//import java.util.List;
//
//@Configuration
//@Transactional
//public class CourseConfig {
//
//    @Bean
//    CommandLineRunner commandLineRunner(CourseRepository courseRepository, TeacherRepository teacherRepository, StudentRepository studentRepository) {
//        return args -> {
//
//            Teacher teacher1 = teacherRepository.findById(Long.valueOf(1)).get();
//            Teacher teacher2 = teacherRepository.findById(Long.valueOf(2)).get();
//
//            List<Student> students = studentRepository.findAll();
//            for (int i = 0; i<=students.size()-1; i++) {
//                students.get(i);
//            }
//
//
//            CourseInformation course1Info = new CourseInformation("back-end",
//                    5,
//                    "Spring Boot is a very nice backend framework",
//                    "Lorem ipsum stuff that is very very long but I am too lazy to type everything",
//                    "SpringBootCoolPictureUrl",
//                    "https://www.youtube.com/watch?v=9SGDpanrc8U");
//
//            CourseInformation course2Info = new CourseInformation("front-end",
//                    3,
//                    "React very nice frontend javascript framework",
//                    "React is a free and open-source front-end JavaScript library for building user interfaces based on UI components. It is maintained by Meta and a community of individual developers and companies.",
//                    "ReactCoolPictureUrl",
//                    "https://www.youtube.com/watch?v=bMknfKXIFA8");
//
//            Course course1 = Course.builder()
//                    .title("Spring Boot Tutorial")
//                    .courseInformation(course1Info)
//                    .courseRating(4.2)
//                    .createdAt(LocalDateTime.now())
//                    .teacher(teacher1)
//                    .students(students)
//                    .build();
//
//            Course course2 = Course.builder()
//                    .title("React Tutorial")
//                    .courseInformation(course2Info)
//                    .courseRating(4.8)
//                    .createdAt(LocalDateTime.now())
//                    .teacher(teacher2)
//                    .build();
//
//            courseRepository.save(course1);
//            courseRepository.save(course2);
//
//
//            System.out.println(courseRepository.findAll());
//        };
//    }
//}
