package com.example.datasetFilter.service;

import org.springframework.web.multipart.MultipartFile;

public interface ImportService {

    void importTiltData(MultipartFile file, int maxNumberOfRecords);

    void importCrewData(MultipartFile file, int maxNumberOfRecords);

    void importNameData(MultipartFile file, int maxNumberOfRecords);

    void importRatingData(MultipartFile file, int maxNumberOfRecords);
}
