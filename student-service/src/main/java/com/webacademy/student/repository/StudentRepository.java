package com.webacademy.student.repository;

import com.webacademy.common.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

   @Query("SELECT s FROM Student s WHERE s.email = ?1")
   Student findStudentByEmail(String email);

   @Query("SELECT s FROM Student s WHERE s.username = ?1")
   Student findStudentByUsername(String username);

   @Query(value = "SELECT s.* FROM student s LEFT OUTER JOIN " +
           "student_course_mapping sc ON s.student_id = sc.student_id " +
           "LEFT OUTER JOIN course c ON sc.course_id = c.course_id " +
           "WHERE sc.course_id = :courseId", nativeQuery = true)
   List<Student> findStudentsByCourseId(@Param("courseId") Long courseId);

   @Query(value = "SELECT s.* FROM student s LEFT OUTER JOIN " +
           "student_course_mapping sc ON s.student_id = sc.student_id " +
           "LEFT OUTER JOIN course c ON sc.course_id = c.course_id " +
           "WHERE sc.course_id = :courseId AND sc.student_id = :studentId", nativeQuery = true)
   Student findStudentByCourseIdAndStudentId(@Param("courseId") Long courseId,
                                             @Param("studentId") Long studentId);

   boolean existsByEmail(String email);

   boolean existsByUsername(String username);

   boolean existsByStudentId(Long studentId);

   boolean existsByEmailAndPassword(String email, String password);
}
