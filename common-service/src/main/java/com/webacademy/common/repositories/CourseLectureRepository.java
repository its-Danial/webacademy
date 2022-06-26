package com.webacademy.common.repositories;

import com.webacademy.common.entities.Course;
import com.webacademy.common.entities.CourseLecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseLectureRepository extends JpaRepository<CourseLecture, Long> {

//    String find
    // todo : CourseLecture by video
    @Query("SELECT c FROM CourseLecture c WHERE c.course.courseId = ?1")
    List<CourseLecture> findLecturesByCourseId(Long id);

}
