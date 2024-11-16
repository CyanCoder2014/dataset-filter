package com.example.datasetFilter.repository;

import com.example.datasetFilter.entity.TitleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TitleRepository  extends JpaRepository<TitleEntity, String> {

    List<TitleEntity> findByTitleType(String titleType);

}
