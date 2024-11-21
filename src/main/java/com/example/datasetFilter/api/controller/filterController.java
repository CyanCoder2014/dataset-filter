package com.example.datasetFilter.api.controller;


import com.example.datasetFilter.entity.TitleEntity;
import com.example.datasetFilter.exceptions.BadRequestException;
import com.example.datasetFilter.service.FilterService;
import com.example.datasetFilter.service.ImportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/filter")
@RequiredArgsConstructor
public class filterController {

    private final FilterService filterService;

    @GetMapping("same")
    public List<TitleEntity> findTitlesWhereDirectorAndWriterAreSame() {

            return filterService.findTitlesWhereDirectorAndWriterAreSame();

    }



}
