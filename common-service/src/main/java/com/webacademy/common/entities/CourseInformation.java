package com.webacademy.common.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Embeddable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class CourseInformation {

    private String categoryTopic;

    private double price;

    private String summary; // small
    private String description; // big

    private String coverPictureUrl;
    private String previewVideoUrl;


}
