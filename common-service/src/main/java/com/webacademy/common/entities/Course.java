package com.webacademy.common.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@JsonIgnoreProperties({"students"})
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
    private double courseRating = 0;

    private LocalDateTime createdAt = LocalDateTime.now();

    @Embedded
    private CourseInformation courseInformation;

/*----------------------------Categories Mapping----------------------------*/

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "course_category_mapping",
            joinColumns = @JoinColumn(
                    name = "course_id",
                    referencedColumnName = "courseId"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "category_id",
                    referencedColumnName = "categoryId"
            )
    )
    @ToString.Exclude
    private List<Category> categories = new ArrayList<>();

    /*----------------------------Teacher Mapping----------------------------*/

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(
            name = "teacher_id",
            referencedColumnName = "teacherId"
    )
    private Teacher teacher;

    /*----------------------------Student Mapping----------------------------*/
    @ManyToMany(
            cascade = CascadeType.MERGE,
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

    public void addStudent(Student student) {
        if (students == null) {
            students = new ArrayList<>();
        }
        students.add(student);
    }

}
