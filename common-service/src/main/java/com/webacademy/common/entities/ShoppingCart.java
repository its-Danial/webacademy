package com.webacademy.common.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private Long cartId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "cart_id", referencedColumnName = "studentId")
    @JsonIgnore
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
    private List<Course> courses;

    public void addCourseToCart(Course c) {
        if (courses == null) {
            courses = new ArrayList<>();
        }
        courses.add(c);
    }


}
