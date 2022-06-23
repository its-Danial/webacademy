package com.webacademy.course_lecture.config;

import com.webacademy.common.entities.Course;
import com.webacademy.common.entities.CourseLecture;
import com.webacademy.course_lecture.repository.CourseLectureRepository;
import com.webacademy.course_lecture.repository.CourseRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.transaction.Transactional;


@Configuration @Transactional
public class CourseLectureConfig {



    @Bean
    CommandLineRunner commandLineRunner(CourseLectureRepository courseLectureRepository, CourseRepo courseRepo) {
        return args -> {



            Course course = courseRepo.findById(Long.valueOf(1))
                    .orElseThrow(()-> new IllegalStateException("oh shit"));


            System.out.println("course = " + course);





//            CourseLecture courseLecture = new CourseLecture(
//                   null,
//                    "title",
//                    "des",
//                    "url",
//                    4,
//                    false,
//                    null
//            );

            CourseLecture courseLecture = courseLectureRepository.findById(Long.valueOf(2)).get();
            
            System.out.println("courseLecture = " + courseLecture);
            courseLecture.setCourse(course);
            System.out.println("courseLecture = " + courseLecture);

//
//            courseLectureRepository.save(courseLecture);
        };
    }
}
