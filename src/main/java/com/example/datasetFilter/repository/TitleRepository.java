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


    @Query("SELECT * from Title_Entity where genres LIKE  '%:genre%' order BY (num_Votes * average_Rating) ASC")
    List<TitleEntity> findByGenreOrderedByRate(@Param("genre") String genre);

}
