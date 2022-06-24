package com.webacademy.student.config;

import com.webacademy.common.entities.Student;
import com.webacademy.student.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args -> {

            Student danial = Student.builder()
                    .email("Danial@email.com")
                    .firstName("firstName")
                    .lastName("LastName")
                    .password("Strong Password")
                    .username("thenial")
                    .build();


            studentRepository.save(danial);
        };
    }
}
