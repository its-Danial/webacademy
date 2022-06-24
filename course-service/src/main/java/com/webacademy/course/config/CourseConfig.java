package com.webacademy.course.config;

import com.webacademy.common.entities.Course;
import com.webacademy.common.entities.CourseInformation;
import com.webacademy.common.entities.CourseLecture;
import com.webacademy.common.entities.Teacher;
import com.webacademy.course.repository.CourseRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.transaction.Transactional;
import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

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
                    "teacher2@email.com",
                    "username",
                    "password",
                    "bio",
                    "avatarUrl"
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
