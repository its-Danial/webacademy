package com.webacademy.teacher.config;
import com.webacademy.common.entities.Teacher;
import com.webacademy.common.repositories.TeacherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TeacherConfig {


    @Bean
    CommandLineRunner commandLineRunner(TeacherRepository teacherRepository) {
        return args -> {
//
//            Course course = Course.builder()
//                    .courseRating(3)
//                    .coverPictureUrl("cover picture")
//                    .description("nice course")
//                    .previewVideoUrl("prev video")
//                    .price(5.3)
//                    .title("Course One")
//                    .build();

//            Teacher teacher = Teacher.builder()
//                    .bioText("good teacher")
//                    .firstName("first name")
//                    .lastName("last name")
//                    .build();
            Teacher teacher = new Teacher(
                    null,
                    "firstname",
                    "lastnamee",
                    "teacher@email.com",
                    "username",
                    "password",
                    "bio",
                    "avatarUrl"
            );

            teacherRepository.save(teacher);

        };
    }
}
