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

    private double price;

    private String summary; // small

    //TODO : @LOB thing to make it save big paragraphs
    private String description; // big

    private String coverImageUrl;
    private String previewVideoUrl;


}
