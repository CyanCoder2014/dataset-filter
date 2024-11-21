package com.example.datasetFilter.repository;

import com.example.datasetFilter.entity.TitleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TitleRepository  extends JpaRepository<TitleEntity, String> {

    Optional<TitleEntity> findById(String id);

    List<TitleEntity> findByTitleType(String titleType);

}
