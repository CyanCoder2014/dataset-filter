package com.example.datasetFilter.entity;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

@Data
@Entity
public class Title {

    @Id
    private String id;

    private String titleType;
    private String primaryTitle;
    private String originalTitle;
    private String isAdult;
    private String startYear;
    private String endYear;
    private String runtimeMinutes;
    private String genres;

    private List<String> directors;
    private List<String> writers;

    private Double averageRating;
    private Integer numVotes;


    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;

}
