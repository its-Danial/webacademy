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
    @SequenceGenerator(
            name = "shopping_cart_sequence",
            sequenceName = "shopping_cart_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shopping_cart_sequence")
    private Long cartId;

    @OneToOne
    @JoinColumn(
            name = "student_id",
            referencedColumnName = "studentId"
    )
    private Student student;


    @OneToMany(cascade = CascadeType.MERGE) //Changed from ALL to MERGE
    @JoinTable(
            name = "cart_course_mapping",
            joinColumns = @JoinColumn(
                    name = "cart_id",
                    referencedColumnName = "cartId"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "course_id",
                    referencedColumnName = "courseId"
            )
    )
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(
//            name = "course_id",
//            referencedColumnName = "courseId"
//    )
    @ToString.Exclude
    private List<Course> course;


    //  At first the list can be empty.
    public void addCourseToCart(Course c) {
        if (course == null) {
            course = new ArrayList<>();
        }
        course.add(c);
    }


}
