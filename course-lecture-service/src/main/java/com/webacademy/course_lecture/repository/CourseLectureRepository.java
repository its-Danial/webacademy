package com.webacademy.course_lecture.repository;

import com.webacademy.common.entities.Course;
import com.webacademy.common.entities.CourseLecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CourseLectureRepository extends JpaRepository<CourseLecture, Long> {

    @Query("SELECT cl FROM CourseLecture cl join fetch cl.course c WHERE c.courseId = ?1")
    List<CourseLecture> findLecturesByCourseId(Long id);

    @Query("SELECT cl FROM CourseLecture cl join fetch cl.course WHERE cl.courseLectureId = ?1")
    Optional<CourseLecture> findCourseLectureById(Long id);

}
