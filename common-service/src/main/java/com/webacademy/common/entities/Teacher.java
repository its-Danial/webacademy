package com.webacademy.common.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "teacher_table", uniqueConstraints = {
        @UniqueConstraint(name = "uc_teacher_email_address", columnNames = {"email_address"})
})
public class Teacher {

    @Id
    @SequenceGenerator(
            name = "teacher_sequence",
            sequenceName = "teacher_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "teacher_sequence"
    )
    private Long teacherId;
    private String firstName;
    private String lastName;
    @Column(name = "email_address", nullable = false)
    private String email;
    private String username;
    private String password;
    private String bioText;
    private String avatarPictureUrl;
}
