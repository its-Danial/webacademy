package com.webacademy.common.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.Lob;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class CourseInformation {

    private double price;

    private String whatYouLearn;

    private String summary;

    @Lob
    private String description;

    private String coverImageUrl;

    private String previewVideoUrl;
}
