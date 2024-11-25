package com.example.datasetFilter.api.controller;


import com.example.datasetFilter.exceptions.BadRequestException;
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
    public void importTitleData(@RequestPart MultipartFile file, @RequestPart String maxNumberOfRecords) {
        try {
            int maxRecords = Integer.parseInt(maxNumberOfRecords);
            importService.importTiltData(file, maxRecords);
        } catch (NumberFormatException ex) {
            throw new BadRequestException("Invalid number format for maxNumberOfRecords. Please provide a valid integer.");
        }
    }

    @PostMapping("crews")
    public void importCrewsData(@RequestPart MultipartFile file, @RequestPart String maxNumberOfRecords) {
        try {
            int maxRecords = Integer.parseInt(maxNumberOfRecords);
            importService.importCrewData(file, maxRecords);
        } catch (NumberFormatException ex) {
            throw new BadRequestException("Invalid number format for maxNumberOfRecords. Please provide a valid integer.");
        }
    }


    @PostMapping("ratings")
    public void importRatingData(@RequestPart MultipartFile file, @RequestPart String maxNumberOfRecords) {
        try {
            int maxRecords = Integer.parseInt(maxNumberOfRecords);
            importService.importRatingData(file, maxRecords);
        } catch (NumberFormatException ex) {
            throw new BadRequestException("Invalid number format for maxNumberOfRecords. Please provide a valid integer.");
        }
    }


    @PostMapping("names")
    public void importNamesData(@RequestPart MultipartFile file, @RequestPart String maxNumberOfRecords) {
        try {
            int maxRecords = Integer.parseInt(maxNumberOfRecords);
            importService.importNameData(file, maxRecords);
        } catch (NumberFormatException ex) {
            throw new BadRequestException("Invalid number format for maxNumberOfRecords. Please provide a valid integer.");
        }
    }

}
