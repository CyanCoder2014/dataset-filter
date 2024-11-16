package com.example.datasetFilter.entity;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

@Data
@Entity
public class TitleEntity {

    @Id
    private String id;

    private String titleType;
    private String primaryTitle;
    private String originalTitle;
    private Boolean isAdult;
    private String startYear;
    private String endYear;
    private Integer runtimeMinutes;
    private List<String> genres;

    private List<String> directors;
    private List<String> writers;

    private Double averageRating;
    private Integer numVotes;


    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;

}
