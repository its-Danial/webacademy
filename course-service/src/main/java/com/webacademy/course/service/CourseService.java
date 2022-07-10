package com.webacademy.course.service;

import com.webacademy.common.entities.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {

    List<Course> findAllCourse();

    List<Course> findCoursesByPage(int page, int size);

    List<Course> paginationByCategory(String categoryName, int page);

    List<Course> paginationByTopic(String topic, int page);

    List<Course> paginationByCategoryAndRating(String categoryName,double minRating, double maxRating, int page);

    List<Course> paginationByTopicAndRating(String topic,double minRating, double maxRating, int page);

    List<Course>findCoursesByTeacherId(Long id);

    List<Course> findCoursesByCategory(String category);

    List<Course> findCoursesByTopic(String topic);

    List<Course> findCourseByRating(double minRating, double maxRating);

    Optional<Course> findCourseByCourseId(Long id);

    List<Course> findCoursesByStudentId(Long id);

    void createCourse(Long teacherId, Course course);

    void deleteCourse(Long teacherId, Long courseId);

    List<Course> findCoursesInCartByStudentId(Long studentId);

    double findTotalPriceEarned(Long teacherId);
}
