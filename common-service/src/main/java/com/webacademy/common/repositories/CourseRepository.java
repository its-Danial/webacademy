package com.webacademy.common.repositories;

import com.webacademy.common.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Long> {



//    todo : find teacher name for the course

}
