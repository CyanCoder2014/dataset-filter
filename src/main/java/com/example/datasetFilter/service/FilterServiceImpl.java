package com.example.datasetFilter.service;


import com.example.datasetFilter.entity.TitleEntity;
import com.example.datasetFilter.repository.TitleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FilterServiceImpl implements FilterService{


    private final TitleRepository titleRepository;

    public List<TitleEntity> findTitlesWhereDirectorAndWriterAreSame(){

        return titleRepository.findTitlesWhereDirectorAndWriterAreSame();
    }

}
