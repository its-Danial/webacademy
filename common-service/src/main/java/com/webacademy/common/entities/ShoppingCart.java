package com.webacademy.common.entities;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class ShoppingCart {

    @Id
//    @SequenceGenerator(
//                name = "student_sequence",
//            sequenceName = "student_sequence",
//            allocationSize = 1
//    )
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
    private Long cartId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "cart_id", referencedColumnName = "studentId")
    private Student student;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "cart_course_mapping",
            joinColumns = @JoinColumn(
                    name = "cart_id",
                    referencedColumnName = "cart_id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "course_id",
                    referencedColumnName = "courseId"
            )
    )
    private List<Course> courses = new ArrayList<>();


    //  At first the list can be empty.
    public void addCourseToCart(Course c) {
        if (courses == null) {
            courses = new ArrayList<>();
        }
        courses.add(c);
    }


}
