package com.webacademy.course_material.repository;

import com.webacademy.course_material.entity.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseMaterialRepository extends JpaRepository<CourseMaterial, Long> {
}
