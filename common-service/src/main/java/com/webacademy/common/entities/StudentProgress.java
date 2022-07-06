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
    @JoinColumn(name = "student_id")
    @JsonIgnore
   private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id")
    @JsonIgnore
   private Course course;

   private int totalLectures;

   private int completedLectures;

   private boolean liked = false;



}
