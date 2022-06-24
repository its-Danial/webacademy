package com.webacademy.course.config;

import com.webacademy.common.entities.Course;
import com.webacademy.common.entities.CourseInformation;
import com.webacademy.common.entities.Teacher;
import com.webacademy.common.repositories.CourseRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Configuration @Transactional
public class CourseConfig {

    @Bean
    CommandLineRunner commandLineRunner(CourseRepository courseRepository) {
        return args -> {


            CourseInformation courseInformation = new CourseInformation("good topic",
                    5,
                    "summary",
                    "description",
                    "url",
                    "video link");



            Teacher teacher = new Teacher(
                    null,
                    "firstname",
                    "lastnamee",
                    "bio",
                    "avatarpic"
            );

            Course course = new Course(
                    null,
                    "title",
                    5,
                    LocalDateTime.now(),
                    40,
                    courseInformation,
                    teacher,
                    null
            );



            courseRepository.save(course);



            System.out.println(courseRepository.findAll());
        };
    }
}
