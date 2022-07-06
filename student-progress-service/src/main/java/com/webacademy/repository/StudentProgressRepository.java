package com.webacademy.repository;

import com.webacademy.common.entities.StudentProgress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StudentProgressRepository extends JpaRepository<StudentProgress, Long> {


    @Query(value = "Select * from student_progress " +
            "where student_id = :studentId and course_id = :courseId", nativeQuery = true)
    StudentProgress findStudentProgressByStudentIdAndCourseId(@Param("studentId") Long studentId,
                                                              @Param("courseId") Long courseId);
}
