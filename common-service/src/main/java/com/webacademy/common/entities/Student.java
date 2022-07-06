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
@Table(name = "student", uniqueConstraints = {
        @UniqueConstraint(name = "uc_student_email_address", columnNames = {"email_address"})
}) // We need all email to be unique, so I added unique constraint for the table.
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize=1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
    private Long studentId;
    private String fullName;
    @Column(name = "email_address", nullable = false)
    private String email;
    private String username;
    private String password;


//    @OneToMany(mappedBy = "student")
//    @ToString.Exclude
//    private List<StudentProgress> progresses;
//
//    public void addProgresses(StudentProgress progress) {
//        if (progresses == null) {
//            progresses = new ArrayList<>();
//        }
//        progresses.add(progress);
//    }
}