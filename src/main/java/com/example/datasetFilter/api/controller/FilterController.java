package com.example.datasetFilter.api.controller;


import com.example.datasetFilter.entity.TitleEntity;
import com.example.datasetFilter.service.FilterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/filter")
@RequiredArgsConstructor
public class FilterController {

    private final FilterService filterService;

    @GetMapping("get-director-writer-same")
    public List<TitleEntity> findTitlesWhereDirectorAndWriterAreSame() {
            return filterService.findTitlesWhereDirectorAndWriterAreSame();
    }



}
