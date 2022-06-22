package com.webacademy.course.config;

import com.webacademy.common.entities.Course;
import com.webacademy.course.repository.CourseRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CourseConfig {

    @Bean
    CommandLineRunner commandLineRunner(CourseRepository courseRepository) {
        return args -> {

            Course course = Course.builder()
                    .courseRating(3)
                    .coverPictureUrl("cover picture")
                    .description("nice course")
                    .previewVideoUrl("prev video")
                    .price(5.3)
                    .title("Course One")
                    .build();


            courseRepository.save(course);

        };
    }
}
