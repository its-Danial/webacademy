package com.webacademy.common.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class StudentProgress {

    @Id
    @SequenceGenerator(
            name = "progress_sequence",
            sequenceName = "progress_sequence",
            allocationSize=1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "progress_sequence")
    private Long studentProgressId;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "studentId")
    @JsonIgnore
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "courseId")
    @JsonIgnore
    private Course course;

    @Column(name="course_id", updatable=false, insertable=false)
    private Long courseId;

    private int totalLectures;

    private int completedLectures = 0;

    private boolean liked = false;
}
