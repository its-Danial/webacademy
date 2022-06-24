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

            Course course1 = courseRepo.findById(Long.valueOf(1)).get();
            Course course2 = courseRepo.findById(Long.valueOf(2)).get();

            System.out.println("course ============= " + course1);

            CourseLecture courseLecture1 = CourseLecture.builder()
                    .course(course1)
                    .title("Overview")
                    .courseLectureDescription("Spring Boot overview")
                    .lectureDuration(LocalDateTime.now())
                    .lectureUrl("https://www.youtube.com/watch?ad71dah871")
                    .build();
            CourseLecture courseLecture2 = CourseLecture.builder()
                    .course(course1)
                    .title("Initializing a Spring boot project")
                    .courseLectureDescription("We are initializing it with Spring Initializr")
                    .lectureDuration(LocalDateTime.now())
                    .lectureUrl("https://www.youtube.com/watch?a423asdfa71")
                    .build();

            CourseLecture courseLecture3 = CourseLecture.builder()
                    .course(course2)
                    .title("Overview")
                    .courseLectureDescription("React overview")
                    .lectureDuration(LocalDateTime.now())
                    .lectureUrl("https://www.youtube.com/watch?v=hQAHSlTtcmY")
                    .build();

            CourseLecture courseLecture4 = CourseLecture.builder()
                    .course(course2)
                    .title("Starting a react project")
                    .courseLectureDescription("To start a react project, we use npx create-react-app your-project")
                    .lectureDuration(LocalDateTime.now())
                    .lectureUrl("https://www.youtube.com/watch?v=d61g&Asdh3")
                    .build();

            courseLectureRepository.save(courseLecture1);
            courseLectureRepository.save(courseLecture2);
            courseLectureRepository.save(courseLecture3);
            courseLectureRepository.save(courseLecture4);

            System.out.println(courseLectureRepository.findAll());

        };
    }
}
