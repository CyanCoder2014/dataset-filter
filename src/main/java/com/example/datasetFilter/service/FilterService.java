package com.example.datasetFilter.service;

import com.example.datasetFilter.entity.TitleEntity;

import java.util.List;

public interface FilterService {

    List<TitleEntity> findTitlesWhereDirectorAndWriterAreSame();
}
