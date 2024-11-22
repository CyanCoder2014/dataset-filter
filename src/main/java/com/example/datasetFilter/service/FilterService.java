package com.example.datasetFilter.service;

import com.example.datasetFilter.api.dto.FilterByActorsRequestDto;
import com.example.datasetFilter.entity.TitleEntity;

import java.util.List;

public interface FilterService {

    List<TitleEntity> findTitlesWhereDirectorAndWriterAreSame();

    List<TitleEntity> filterByActors(FilterByActorsRequestDto requestDto);
}
