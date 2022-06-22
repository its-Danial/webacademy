package com.webacademy.course_lecture.config;

import com.sun.org.apache.xml.internal.utils.res.CharArrayWrapper;
import com.webacademy.common.entities.Course;
import com.webacademy.common.entities.CourseInformation;
import com.webacademy.common.entities.CourseLecture;
import com.webacademy.common.entities.Teacher;
import com.webacademy.course_lecture.repository.CourseLectureRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Configuration
public class CourseLectureConfig {

    @Bean
    CommandLineRunner commandLineRunner(CourseLectureRepository courseLectureRepository) {
        return args -> {

            CourseInformation courseInformation = new CourseInformation("Pogramming", 5,
                    "you'll learn everything about python",
                    "big descriptipon",
                    "some picture",
                    "https://www.youtube.com/watch?v=rfscVS0vtbw");

            Teacher teacher = Teacher.builder()
                    .bioText("5 years of experience")
                    .avatarPictureUrl("some picture")
                    .firstName("Danial")
                    .lastName("azhar")
                    .build();

            Course course = Course.builder()
                    .courseRating(5)
                    .title("python for beginners")
                    .completedProgress(40)
                    .courseInformation(courseInformation)
                    .createdAt(LocalDateTime.now())
                    .teacher(teacher)
                    .build();


           CourseLecture courseLecture = CourseLecture.builder()
                    .course(course)
                    .courseLectureDescription("best course")
                    .lectureUrl("https://www.youtube.com/watch?v=rfscVS0vtbw")
                    .title("Setting up python environment")
                    .isCompleted(false)
                    .lectureDuration(5)
                    .build();

            courseLectureRepository.save(courseLecture);
        };
    }
}
