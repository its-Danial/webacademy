package com.webacademy.teacher.repository;

import com.webacademy.common.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository  extends JpaRepository<Teacher, Long> {
}
