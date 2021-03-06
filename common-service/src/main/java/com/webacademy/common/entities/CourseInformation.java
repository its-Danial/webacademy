package com.webacademy.common.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.Lob;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class CourseInformation implements Serializable {

    private Double price = 0.0;

    private String whatYouLearn;

    private String summary;

    @Lob
    private String description;

    private String coverImageUrl;

    private String previewVideoUrl;

    private Double totalDuration;
}
