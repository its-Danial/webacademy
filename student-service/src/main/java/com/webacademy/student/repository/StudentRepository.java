package com.webacademy.student.repository;

import com.webacademy.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

   Student findStudentByEmailId(String email);


}
