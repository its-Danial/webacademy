package com.webacademy.common.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Course {

    @Id
    @SequenceGenerator(
            name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_sequence")
    private Long courseId;

    private String title;

    // TODO:
    //  -   add constraint for 0-5 start
    private double courseRating;

    private LocalDateTime createdAt; // maybe different kind of date, I used this before.

    private double completedProgress = 0; // When the user watched a lecture this should be updated
    // get all completed lectures and divide by total lectures and set this to that value.

    @Embedded
    private CourseInformation courseInformation;

//   ----------------------------------------Table Relationship Mapping-----------------------------------------

//   ---------------------------------------- Course Lecture Mapping-----------------------------------------



//   ---------------------------------------- Teacher Mapping-----------------------------------------
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "teacher_id",
            referencedColumnName = "teacherId"
    )
    private Teacher teacher;

//  ---------------------------------------- Student Mapping-----------------------------------------
    @ManyToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY

    )
    @JoinTable(
            name = "student_course_mapping",
            joinColumns = @JoinColumn(
                    name = "course_id",
                    referencedColumnName = "courseId"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "student_id",
                    referencedColumnName = "studentId"
            )
    )
    @ToString.Exclude
    private List<Student> students;

    //  At first the list can be empty.
    public void addStudent(Student student) {
        if (students == null) {
            students = new ArrayList<>();
            students.add(student);
        }
    }

}
