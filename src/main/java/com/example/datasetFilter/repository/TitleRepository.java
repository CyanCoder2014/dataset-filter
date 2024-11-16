package com.example.datasetFilter.repository;

import com.example.datasetFilter.entity.Title;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TitleRepository  extends JpaRepository<Title, String> {

    List<Title> findByTitleType(String titleType);

}
