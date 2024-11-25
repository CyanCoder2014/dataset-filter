package com.example.datasetFilter.service;


import com.example.datasetFilter.api.dto.FilterByActorsRequestDto;
import com.example.datasetFilter.entity.NameEntity;
import com.example.datasetFilter.entity.TitleEntity;
import com.example.datasetFilter.exceptions.BadRequestException;
import com.example.datasetFilter.repository.NameRepository;
import com.example.datasetFilter.repository.TitleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
    public List<TitleEntity> filterByActors(FilterByActorsRequestDto requestDto) {

        NameEntity actorEntity1 = nameRepository.findCommonMovieTitlesByActor(requestDto.actor1())
                .orElseThrow(()->new BadRequestException("Actor 1 dose not exist"));

        NameEntity actorEntity2 = nameRepository.findCommonMovieTitlesByActor(requestDto.actor2())
                .orElseThrow(()->new BadRequestException("Actor 2 dose not exist"));

        List<String> titleIds = actorEntity1.getKnownForTitles().stream().filter(actorEntity2.getKnownForTitles()::contains).toList();

        return titleRepository.findAllByIdIn(titleIds);
    }


    @Override
    public List<TitleEntity> findByGenreOrderedByRate(String genre){

        return titleRepository.findByGenreOrderedByRate(genre);
    }

    public List<TitleEntity> findAllByPartialCommonDirAndWriterPartially(){

        return titleRepository.findAllByPartialCommonDir(true);
    }

}
