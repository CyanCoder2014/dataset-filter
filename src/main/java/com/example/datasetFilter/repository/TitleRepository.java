package com.example.datasetFilter.repository;

import com.example.datasetFilter.entity.TitleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TitleRepository  extends JpaRepository<TitleEntity, String> {


    List<TitleEntity> findByTitleType(String titleType);

    @Query(value = "SELECT t.* , n.*  FROM Title_Entity AS t \n" +
            "JOIN Name_Entity n \n" +
            "ON n.id = TRIM('[]' FROM t.directors)\n" +
            "where TRIM('[]' FROM t.directors) = TRIM('[]' FROM t.writers)\n" +
            "and end_year = '\\N'\n " ,
            nativeQuery = true)
    List<TitleEntity> findTitlesWhereDirectorAndWriterAreSame();


    List<TitleEntity> findAllByIdIn(List<String> ids);


}
