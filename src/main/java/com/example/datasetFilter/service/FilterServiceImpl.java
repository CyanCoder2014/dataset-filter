package com.example.datasetFilter.service;


import com.example.datasetFilter.api.dto.FilterByActorsRequestDto;
import com.example.datasetFilter.entity.NameEntity;
import com.example.datasetFilter.entity.TitleEntity;
import com.example.datasetFilter.repository.NameRepository;
import com.example.datasetFilter.repository.TitleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FilterServiceImpl implements FilterService{


    private final TitleRepository titleRepository;
    private final NameRepository nameRepository;

    @Override
    public List<TitleEntity> findTitlesWhereDirectorAndWriterAreSame(){

        return titleRepository.findTitlesWhereDirectorAndWriterAreSame();
    }

    @Override
    public List<NameEntity> filterByActors(FilterByActorsRequestDto requestDto) {

        return nameRepository.findCommonMovieTitlesByActors(requestDto.actor1(), requestDto.actor2());
    }

}
