package com.webacademy.common.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

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

    private String title;

    @Lob
    private String courseLectureDescription;

    private String lectureUrl;

    private String lectureDuration;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", referencedColumnName = "courseId")
    @ToString.Exclude
    @JsonIgnore
    public Course course;
}
