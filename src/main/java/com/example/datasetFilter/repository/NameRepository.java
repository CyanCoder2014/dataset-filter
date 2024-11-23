package com.example.datasetFilter.repository;

import com.example.datasetFilter.entity.NameEntity;
import com.example.datasetFilter.entity.TitleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface NameRepository extends JpaRepository<NameEntity, String> {


    @Query(value = "SELECT * FROM name_entity " +
            "WHERE primary_Name = :actor " ,
            nativeQuery = true)
    Optional<NameEntity> findCommonMovieTitlesByActor(@Param("actor") String actor);


}
