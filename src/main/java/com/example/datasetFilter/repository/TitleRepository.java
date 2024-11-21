package com.example.datasetFilter.repository;

import com.example.datasetFilter.entity.TitleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TitleRepository  extends JpaRepository<TitleEntity, String> {

    Optional<TitleEntity> findById(String id);

    List<TitleEntity> findByTitleType(String titleType);

    @Query(value = "SELECT * FROM Title_Entity t " +
            "WHERE t.directors LIKE CONCAT('%', ',', t.writers, ',', '%') " +
            "OR t.directors LIKE CONCAT('%', t.writers, '%')",
            nativeQuery = true)
    List<TitleEntity> findTitlesWhereDirectorAndWriterAreSame();

}
