package com.webacademy.course.repository;

import com.webacademy.common.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course,Long> {

    List<Course>findByTopic(String topic);

//    todo : find teacher name for the course

}
