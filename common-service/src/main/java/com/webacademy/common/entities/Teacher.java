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
@Table(name = "teacher", uniqueConstraints = {
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

    private String fullName;

    @Column(name = "email_address", nullable = false)
    private String email;

    private String username;

    private String password;

    @Lob
    private String bioText;

    private String avatarPictureUrl;
    //TODO: When a teacher add a lecture, does it show in students
}
