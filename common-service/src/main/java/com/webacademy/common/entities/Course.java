package com.webacademy.common.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    // This will be 255 var, I can set it as type TEXT if needed
    private String description;
    private double price;

    private String coverPictureUrl;
    private String previewVideoUrl;
    private double courseRating;


    //  Without this it is one-to-one "uni-directional mapping" which means when we fetch data for Courses we don't
    //  get Course Material data. With "mappedBy = "course"" we will also get course material data
    @OneToOne(
            mappedBy = "course"
    )
    private CourseMaterial courseMaterial;

    // One Teacher can Teach Many Courses. P.S. It is recommended to user ManyToOne mapping instead of
    // OneToMany, that is why it is in this entity class.
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "teacher_id",
            referencedColumnName = "teacherId"
    )
    private Teacher teacher;

    // Many Courses can be taken my one student and A course can be taken by Many student.
    @ManyToMany(
            cascade = CascadeType.ALL
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
    private List<Student> students;
    // At first the list can be empty.
    public void addStudent(Student student) {
        if (students == null) {
            students = new ArrayList<>();
            students.add(student);
        }
    }



}
