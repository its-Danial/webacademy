package com.webacademy.common.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "student", uniqueConstraints = {
        @UniqueConstraint(name = "uc_student_email_address", columnNames = {"email_address"}),
        @UniqueConstraint(name="uc_student_username", columnNames = {"username"})
})
public class Student implements Serializable{

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

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
}