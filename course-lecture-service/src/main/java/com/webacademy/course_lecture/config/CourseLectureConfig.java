//package com.webacademy.course_lecture.config;
//
//import com.webacademy.common.entities.Course;
//import com.webacademy.common.entities.CourseLecture;
//import com.webacademy.course_lecture.repository.CourseLectureRepository;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.time.Duration;
//import java.util.Arrays;
//import java.util.List;
//
//
//@Configuration
//@Slf4j
//public class CourseLectureConfig {
//
//    public String timeFormat(long minutes){
//        Duration duration = Duration.ofMinutes(minutes);
//        long seconds = duration.getSeconds();
//        return String.format("%d:%02d:%02d", seconds / 3600, (seconds % 3600) / 60, (seconds % 60));
//    }
//    @Bean
//    CommandLineRunner commandLineRunner(CourseLectureRepository courseLectureRepository) {
//        return args -> {
//
//            Course course1 = courseRepo.findById(Long.valueOf(1)).get();
//            Course course2 = courseRepo.findById(Long.valueOf(2)).get();
//
//            System.out.println("course ============= " + course1);
//
//            CourseLecture courseLecture1 = CourseLecture.builder()
//                    .course(course1)
//                    .title("Overview")
//                    .courseLectureDescription("Spring Boot overview")
//                    .lectureDuration(timeFormat(50))
//                    .lectureUrl("https://www.youtube.com/watch?ad71dah871")
//                    .build();
//            CourseLecture courseLecture2 = CourseLecture.builder()
//                    .course(course1)
//                    .title("Initializing a Spring boot project")
//                    .courseLectureDescription("We are initializing it with Spring Initializr")
//                    .lectureDuration(timeFormat(72))
//                    .lectureUrl("https://www.youtube.com/watch?a423asdfa71")
//                    .build();
//
//            CourseLecture courseLecture3 = CourseLecture.builder()
//                    .course(course2)
//                    .title("Overview")
//                    .courseLectureDescription("React overview")
//                    .lectureDuration(timeFormat(32))
//                    .lectureUrl("https://www.youtube.com/watch?v=hQAHSlTtcmY")
//                    .build();
//
//            CourseLecture courseLecture4 = CourseLecture.builder()
//                    .course(course2)
//                    .title("Starting a react project")
//                    .courseLectureDescription("To start a react project, we use npx create-react-app your-project")
//                    .lectureDuration(timeFormat(3))
//                    .lectureUrl("https://www.youtube.com/watch?v=d61g&Asdh3")
//                    .build();
//
//            List<CourseLecture> lectures = Arrays.asList(courseLecture1, courseLecture2, courseLecture3, courseLecture4);
//
//            courseLectureRepository.saveAll(lectures);
//
//            System.out.println(courseLectureRepository.findAll());
//
//        };
//    }
//}
