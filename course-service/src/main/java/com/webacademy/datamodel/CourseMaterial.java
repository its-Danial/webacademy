package com.webacademy.datamodel;

import com.webacademy.course.entity.Course;
import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "course")
@Builder

@Entity
public class CourseMaterial {

    @Id
    @SequenceGenerator(
            name = "course_material_sequence",
            sequenceName = "course_material_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_material_sequence"
    )
    private Long courseMaterialId;
    private String title;
    private String courseMaterialDescription;
    private String lectureUrl;
    private double lectureDuration;

    // cascade = CascadeType.ALL will allow us to save new data with parent data
    // FetchType.LAZY will only return values of course material when we search
    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            optional = false
    )
    // Joining Course table with course Material
    @JoinColumn(
            name = "course_id",
            referencedColumnName = "courseId"
    )
    private Course course;

}
