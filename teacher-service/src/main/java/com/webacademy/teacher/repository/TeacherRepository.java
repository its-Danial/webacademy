package com.webacademy.teacher.repository;

import com.webacademy.common.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository  extends JpaRepository<Teacher, Long> {

    @Query("SELECT t FROM Teacher t WHERE t.email = ?1")
    Teacher findTeacherByEmail(String email);

    Teacher findTeacherByUsername(String username);

    boolean existsByEmail(String email);

    boolean existsByUsername(String username);

    boolean existsByTeacherId(Long teacherId);

    boolean existsByEmailAndPassword(String email, String password);

    List<Teacher> findTeachersByEmailContainingIgnoreCase(String email);

}
