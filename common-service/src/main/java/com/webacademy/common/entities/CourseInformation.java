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

    private String summary; // small

    //TODO : @LOB thing to make it save big paragraphs
    @Lob
    private String description; // big

    private String coverImageUrl;
    private String previewVideoUrl;


}
