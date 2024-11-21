package com.example.datasetFilter.service;

import org.springframework.web.multipart.MultipartFile;

public interface ImportService {

    void importTiltData(MultipartFile file, int maxNumberOfRecords);
}
