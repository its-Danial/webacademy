package com.webacademy.course_lecture.config;

import com.webacademy.common.entities.Course;
import com.webacademy.common.entities.CourseLecture;
import com.webacademy.common.repositories.CourseLectureRepository;
import com.webacademy.common.repositories.CourseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;


@Configuration
@Slf4j
public class CourseLectureConfig {



    @Bean
    CommandLineRunner commandLineRunner(CourseLectureRepository courseLectureRepository, CourseRepository courseRepo) {
        return args -> {



            Course course = courseRepo.findById(Long.valueOf(1)).get();

            System.out.println("course ============= " + course);

            CourseLecture courseLecture = new CourseLecture(
                    null,
                    "course lecture title",
                    "des",
                    "url",
                    LocalDateTime.now(),
                    false,
                    course
            );





            courseLectureRepository.save(courseLecture);

            System.out.println(courseLectureRepository.findAll());

        };
    }
}
