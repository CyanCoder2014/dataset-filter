package com.example.datasetFilter.service;


import com.example.datasetFilter.api.dto.FilterByActorsRequestDto;
import com.example.datasetFilter.entity.TitleEntity;
import com.example.datasetFilter.repository.TitleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FilterServiceImpl implements FilterService{


    private final TitleRepository titleRepository;

    @Override
    public List<TitleEntity> findTitlesWhereDirectorAndWriterAreSame(){

        return titleRepository.findTitlesWhereDirectorAndWriterAreSame();
    }

    @Override
    public List<TitleEntity> filterByActors(FilterByActorsRequestDto requestDto) {



        return null;
    }

}
