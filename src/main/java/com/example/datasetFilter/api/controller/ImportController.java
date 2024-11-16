package com.example.datasetFilter.api.controller;


import com.example.datasetFilter.service.ImportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/import")
@RequiredArgsConstructor
public class ImportController {

    private final ImportService importService;

    @PostMapping("titles")
    public void importData(@RequestPart MultipartFile file) {
         importService.importTiltData(file);
    }
}
