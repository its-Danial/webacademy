package com.webacademy.common.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class CourseInformation {

//    @ElementCollection
//    @LazyCollection(LazyCollectionOption.FALSE) // without this it can't lazily load
//    private List<String> categories;


    private double price;

    private String summary; // small
    private String description; // big

    private String coverPictureUrl;
    private String previewVideoUrl;


}
