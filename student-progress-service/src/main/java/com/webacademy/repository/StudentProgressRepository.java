package com.webacademy.repository;

import com.webacademy.common.entities.StudentProgress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentProgressRepository extends JpaRepository<StudentProgress, Long> {


    @Query(value = "Select * from student_progress " +
            "where student_id = :studentId and course_id = :courseId", nativeQuery = true)
    StudentProgress findProgressByStudentIdAndCourseId(@Param("studentId") Long studentId,
                                                       @Param("courseId") Long courseId);

    @Query(value = "SELECT * FROM student_progress WHERE student_id = :studentId", nativeQuery = true)
    List<StudentProgress> findProgressesByStudentId(@Param("studentId") Long studentId);

    @Query(value = "SELECT * FROM student_progress WHERE course_id = :courseId", nativeQuery = true)
    List<StudentProgress> findProgressesByCourseId(@Param("courseId") Long courseId);

}
