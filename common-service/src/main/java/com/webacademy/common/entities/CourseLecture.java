package com.webacademy.common.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class CourseLecture {

    @Id
    @SequenceGenerator(
            name = "course_lecture_sequence",
            sequenceName = "course_lecture_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_lecture_sequence"
    )
    private Long courseLectureId;
    private String title; // e.g introduction to html

    private String courseLectureDescription; // e.g you will learn how to write html and good practices
    private String lectureUrl; // this will be a video link
    private LocalDateTime lectureDuration; // this will be how long the course/video is. NOTE this should be date type

    private boolean isCompleted = false; // when student clicks the lecture, it should be marked as watched

//  ----------------------------------------Table Relationship Mapping-----------------------------------------

//     cascade = CascadeType.ALL will allow us to save new data with parent data
//     FetchType.LAZY will only return values of course lecture when we search


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", referencedColumnName = "courseId")
    @ToString.Exclude
    public Course course;



}
