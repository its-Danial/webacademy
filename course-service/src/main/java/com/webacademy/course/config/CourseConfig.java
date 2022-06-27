package com.webacademy.course.config;

import com.webacademy.common.entities.Category;
import com.webacademy.common.entities.Course;
import com.webacademy.common.entities.CourseInformation;
import com.webacademy.common.entities.Teacher;
import com.webacademy.course.feign.TeacherFeignClient;
import com.webacademy.course.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@Transactional
public class CourseConfig {
    @Autowired
    TeacherFeignClient teacherFeignClient;

    @Bean
    CommandLineRunner commandLineRunner(CourseRepository courseRepository) {
        return args -> {

//
//            List<Student> students = studentRepository.findAll();
//            for (int i = 0; i<=students.size()-1; i++) {
//                students.get(i);
//            }

            Teacher teacher1 = teacherFeignClient.getTeacherById(1L).get();
            Teacher teacher2 = teacherFeignClient.getTeacherById(2L).get();

            CourseInformation course1Info = new CourseInformation(
                    5.0,
                    "summary",
                    "description",
                    "coverUrl",
                    "previewVideoUrl");

            CourseInformation course2Info = new CourseInformation(
                    6.0,
                    "summary2",
                    "description2",
                    "coverUrl2",
                    "previewVideoUrl2");

            List<String> topics1 = Arrays.asList("a", "b", "c");
            List<String> topics2 = Arrays.asList("d", "e", "f");
            List<String> topics3 = Arrays.asList("g", "h", "i");
            List<String> topics4 = Arrays.asList("j", "k", "l");

            Category category1 = new Category(null, "Foo", topics1);
            Category category2 = new Category(null, "Bar", topics2);
            Category category3 = new Category(null, "Something", topics3);
            Category category4 = new Category(null, "Whatever", topics4);

            List<Category> categoryList1 = Arrays.asList(category1, category2);
            List<Category> categoryList2 = Arrays.asList(category3, category4);

            Course course1 = Course.builder()
                    .title("Spring Boot Tutorial")
                    .courseInformation(course1Info)
                    .courseRating(4.2)
                    .createdAt(LocalDateTime.now())
                    .teacher(teacher1)
                    .categories(categoryList1)
//                    .students(students)
                    .build();

            Course course2 = Course.builder()
                    .title("React Tutorial")
                    .courseInformation(course2Info)
                    .courseRating(4.8)
                    .createdAt(LocalDateTime.now())
                    .teacher(teacher2)
                    .categories(categoryList2)
                    .build();

            courseRepository.save(course1);
            courseRepository.save(course2);


            System.out.println(courseRepository.findAll());
        };
    }
}
