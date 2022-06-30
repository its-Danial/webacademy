package com.webacademy.course.config;

import com.webacademy.common.entities.*;
import com.webacademy.course.feign.StudentFeignClient;
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
    @Autowired
    StudentFeignClient studentFeignClient;

    @Bean
    CommandLineRunner commandLineRunner(CourseRepository courseRepository) {
        return args -> {

//            List<Student> students = studentFeignClient.getAllStudent();
//            for (int i = 0; i<=students.size()-1; i++) {
//                students.get(i);
//            }
            Student student1 = studentFeignClient.getStudentById(1L).get();
            Student student2 = studentFeignClient.getStudentById(2L).get();
            Student student3 = studentFeignClient.getStudentById(3L).get();
            Student student4 = studentFeignClient.getStudentById(4L).get();

            List<Student> studentList1 = Arrays.asList(student1, student2);
            List<Student> studentList2 = Arrays.asList(student3, student4);

            Teacher teacher1 = teacherFeignClient.getTeacherById(1L).get();
            Teacher teacher2 = teacherFeignClient.getTeacherById(2L).get();

            CourseInformation course1Info = new CourseInformation(
                    5.0,
                    "summary",
                    "description",
                    "coverImageUrl",
                    "previewVideoUrl");

            CourseInformation course2Info = new CourseInformation(
                    6.0,
                    "summary2",
                    "description2",
                    "coverImageUrl2",
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
                    .students(studentList1)
                    .build();

            Course course2 = Course.builder()
                    .title("React Tutorial")
                    .courseInformation(course2Info)
                    .courseRating(4.8)
                    .createdAt(LocalDateTime.now())
                    .teacher(teacher2)
                    .categories(categoryList2)
                    .students(studentList2)
                    .build();

            courseRepository.save(course1);
            courseRepository.save(course2);


            System.out.println(courseRepository.findAll());
            System.out.println();
        };
    }
}
