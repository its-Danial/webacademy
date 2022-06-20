package com.webacademy.course_material.config;

import com.webacademy.course_material.entity.CourseMaterial;
import com.webacademy.course_material.repository.CourseMaterialRepository;
import com.webacademy.datamodel.Course;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CourseMaterialConfig {

    @Bean
    CommandLineRunner commandLineRunner(CourseMaterialRepository courseMaterialRepository) {
        return args -> {

            Course course = Course.builder()
                    .courseRating(3)
                    .coverPictureUrl("cover picture")
                    .description("nice course")
                    .previewVideoUrl("prev video")
                    .price(5.3)
                    .title("Course One")
                    .build();

            CourseMaterial courseMaterial = CourseMaterial.builder()
                    .courseMaterialDescription("nice course material")
                    .lectureDuration(5.0)
                    .lectureUrl("nice url")
                    .title("title")
                    .course(course)
                    .build();


            courseMaterialRepository.save(courseMaterial);
        };
    }
}
