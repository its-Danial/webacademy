package com.webacademy.course.config;

import com.webacademy.common.entities.Course;
import com.webacademy.common.entities.CourseInformation;
import com.webacademy.course.repository.CourseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Arrays;

@Configuration
@Transactional
public class CourseConfig {

    @Bean
    CommandLineRunner commandLineRunner(CourseRepository courseRepository) {
        return args -> {

//            Teacher teacher1 = teacherRepository.findById(Long.valueOf(1)).get();
//            Teacher teacher2 = teacherRepository.findById(Long.valueOf(2)).get();
//
//            List<Student> students = studentRepository.findAll();
//            for (int i = 0; i<=students.size()-1; i++) {
//                students.get(i);
//            }

//
            CourseInformation course1Info = new CourseInformation(
                    Arrays.asList("foo", "bar"),
                    Arrays.asList("a", "b"),
                    5.0,
                    "summary",
                    "description",
                    "coverUrl",
                    "previewVideoUrl");

            CourseInformation course2Info = new CourseInformation(
                    Arrays.asList("foo2", "bar2"),
                    Arrays.asList("a2", "b2"),
                    6.0,
                    "summary2",
                    "description2",
                    "coverUrl2",
                    "previewVideoUrl2");

            Course course1 = Course.builder()
                    .title("Spring Boot Tutorial")
                    .courseInformation(course1Info)
                    .courseRating(4.2)
                    .createdAt(LocalDateTime.now())
//                    .teacher(teacher1)
//                    .students(students)
                    .build();

            Course course2 = Course.builder()
                    .title("React Tutorial")
                    .courseInformation(course2Info)
                    .courseRating(4.8)
                    .createdAt(LocalDateTime.now())
//                    .teacher(teacher2)
                    .build();

            courseRepository.save(course1);
            courseRepository.save(course2);


            System.out.println(courseRepository.findAll());
        };
    }
}
