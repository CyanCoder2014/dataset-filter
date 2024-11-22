package com.example.datasetFilter.service;

import com.example.datasetFilter.api.dto.FilterByActorsRequestDto;
import com.example.datasetFilter.entity.NameEntity;
import com.example.datasetFilter.entity.TitleEntity;

import java.util.List;

public interface FilterService {

    List<TitleEntity> findTitlesWhereDirectorAndWriterAreSame();

    List<NameEntity> filterByActors(FilterByActorsRequestDto requestDto);
}
