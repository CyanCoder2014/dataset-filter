package com.example.datasetFilter.repository;

import com.example.datasetFilter.entity.TitleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TitleRepository  extends JpaRepository<TitleEntity, String> {


    List<TitleEntity> findByTitleType(String titleType);

    @Query(value = "SELECT * FROM Title_Entity t " +
            "WHERE t.directors = t.writers " ,
            nativeQuery = true)
    List<TitleEntity> findTitlesWhereDirectorAndWriterAreSame();


    List<TitleEntity> findAllByIdIn(List<String> ids);


}
