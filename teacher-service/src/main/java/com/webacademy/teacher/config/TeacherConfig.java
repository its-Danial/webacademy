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

            Teacher teacher1 = Teacher.builder()
                    .email("profben@email.com")
                    .firstName("Ben")
                    .lastName("Dover")
                    .password("1234")
                    .username("bendover123")
                    .bioText("I teach how to bend over")
                    .avatarPictureUrl("pinterest.com/apictureofmebendingover.jpg")
                    .build();

            Teacher teacher2 = Teacher.builder()
                    .email("profkanye@email.com")
                    .firstName("Kanye")
                    .lastName("Northeast")
                    .password("1234")
                    .username("kanyene123")
                    .bioText("I teach in NEU because I was born to do it")
                    .avatarPictureUrl("pinterest.com/apictureofmeandmybrother.jpg")
                    .build();

            teacherRepository.save(teacher1);
            teacherRepository.save(teacher2);
        };
    }
}
