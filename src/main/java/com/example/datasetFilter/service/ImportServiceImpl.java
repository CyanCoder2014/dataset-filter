package com.example.datasetFilter.service;


import com.example.datasetFilter.entity.NameEntity;
import com.example.datasetFilter.entity.TitleEntity;
import com.example.datasetFilter.repository.NameRepository;
import com.example.datasetFilter.repository.TitleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class ImportServiceImpl implements ImportService {

    private final TitleRepository titleRepository;
    private final NameRepository nameRepository;


    public void importTiltData(MultipartFile file) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            String line;
            boolean firstLine = true;

            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false; // Skip header
                    continue;
                }
                String[] fields = line.split("\t");
                TitleEntity titleEntity = new TitleEntity();
                titleEntity.setId(fields[0]);
                titleEntity.setTitleType(fields[1]);
                titleEntity.setPrimaryTitle(fields[2]);
                titleEntity.setOriginalTitle(fields[3]);
                titleEntity.setIsAdult(Boolean.valueOf(fields[4]));
                titleEntity.setStartYear(fields[5]);
                titleEntity.setEndYear(fields[6]);
                titleEntity.setRuntimeMinutes(Integer.parseInt(fields[7]));

                String genresStr = fields[8].equals("\\N") ? "" : fields[8];
                titleEntity.setGenres(Arrays.stream(genresStr.split(",")).toList());

                titleRepository.save(titleEntity);
            }
        } catch (IOException e) {
            throw new RuntimeException(e); // todo: dev exception handler
        }
    }


}
