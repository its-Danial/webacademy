package com.webacademy.common.entities;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "student", uniqueConstraints = {
        @UniqueConstraint(name = "uc_student_email_address", columnNames = {"email_address"})
})
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
}