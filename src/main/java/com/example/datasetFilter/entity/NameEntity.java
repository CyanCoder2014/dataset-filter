package com.example.datasetFilter.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

@Data
@Entity
public class NameEntity {

    @Id
    private String id;

    private String primaryName;
    private String birthYear;
    private String deathYear;
    private String primaryProfession;
    private List<String> knownForTitles;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;

}
