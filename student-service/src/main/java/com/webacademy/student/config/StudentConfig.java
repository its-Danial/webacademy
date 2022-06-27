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
                    .email("danial@email.com")
                    .firstName("Danial")
                    .lastName("Azhar")
                    .password("strongpassword")
                    .username("thenial")
                    .build();

            Student melvern = Student.builder()
                    .email("melvern@email.com")
                    .firstName("Melvern")
                    .lastName("Ardell")
                    .password("1234")
                    .username("VLDR")
                    .build();

            Student hardy = Student.builder()
                    .email("hardy@email.com")
                    .firstName("Hardy")
                    .lastName("Henri")
                    .password("1234")
                    .username("HardBoi")
                    .build();

            Student ferdy = Student.builder()
                    .email("ferdy@email.com")
                    .firstName("Ferdy")
                    .lastName("Luis")
                    .password("1234")
                    .username("Luizzz")
                    .build();

            studentRepository.save(danial);
            studentRepository.save(melvern);
            studentRepository.save(hardy);
            studentRepository.save(ferdy);
        };
    }
}
