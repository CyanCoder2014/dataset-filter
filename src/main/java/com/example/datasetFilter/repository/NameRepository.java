package com.example.datasetFilter.repository;

import com.example.datasetFilter.entity.NameEntity;
import com.example.datasetFilter.entity.TitleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NameRepository extends JpaRepository<NameEntity, String> {


    @Query(value = "SELECT t1.* " +
            "FROM name_entity t1, name_entity t2 " +
            "WHERE t1.primary_name = :actor1 " +
            "AND t2.primary_name = :actor2 " +
            "AND ',' || t1.known_for_titles || ',' LIKE '%,' || t2.known_for_titles || ',%'",
            nativeQuery = true)
    List<NameEntity> findCommonMovieTitlesByActors(@Param("actor1") String actor1, @Param("actor2") String actor2);


}
