package com.webacademy.common.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Embeddable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class CourseInformation {

    private List<String> categories;
    private List<String> topics;


    private double price;

    private String summary; // small
    private String description; // big

    private String coverPictureUrl;
    private String previewVideoUrl;


}
