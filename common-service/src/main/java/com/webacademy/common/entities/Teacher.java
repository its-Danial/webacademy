package com.webacademy.common.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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
        @UniqueConstraint(name = "uc_teacher_email_address", columnNames = {"email_address"}),
        @UniqueConstraint(name="uc_teacher_username", columnNames = {"username"})
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

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Lob
    private String bioText;

    private String avatarPictureUrl;
    //TODO: When a teacher add a lecture, does it show in students
}
