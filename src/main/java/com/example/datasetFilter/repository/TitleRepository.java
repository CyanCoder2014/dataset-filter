package com.example.datasetFilter.repository;

import com.example.datasetFilter.entity.TitleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TitleRepository  extends JpaRepository<TitleEntity, String> {


    List<TitleEntity> findByTitleType(String titleType);

    @Query(value = "SELECT t.* , n.id AS n_id, n.death_Year  FROM Title_Entity AS t \n" +
            "JOIN Name_Entity n \n" +
            "ON n.id = TRIM('[]' FROM t.directors)\n" +
            "where TRIM('[]' FROM t.directors) = TRIM('[]' FROM t.writers)\n" +
            "and death_Year = '\\N'\n " ,
            nativeQuery = true)
    List<TitleEntity> findTitlesWhereDirectorAndWriterAreSame();


    List<TitleEntity> findAllByIdIn(List<String> ids);


    @Query(value ="SELECT t.* FROM Title_Entity t " +
            "where t.genres LIKE CONCAT('%', :genre, '%') " +
            "ORDER BY (t.num_Votes * t.average_Rating) ASC",
            nativeQuery = true)
    List<TitleEntity> findByGenreOrderedByRate(@Param("genre") String genre);


    List<TitleEntity> findAllByPartialCommonDir(boolean partialCommonDirAndWriter);


}
