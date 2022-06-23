package com.webacademy.course_lecture.repository;

import com.webacademy.common.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course, Long> {
}
