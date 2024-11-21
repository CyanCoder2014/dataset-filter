package com.example.datasetFilter.service;


import com.example.datasetFilter.entity.NameEntity;
import com.example.datasetFilter.entity.TitleEntity;
import com.example.datasetFilter.exceptions.BadRequestException;
import com.example.datasetFilter.repository.NameRepository;
import com.example.datasetFilter.repository.TitleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ImportServiceImpl implements ImportService {

    private final TitleRepository titleRepository;
    private final NameRepository nameRepository;


    public void importTiltData(MultipartFile file, int maxNumberOfRecords) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            String line;
            boolean firstLine = true;

            int number = 0;
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
                titleEntity.setIsAdult(!fields[4].equals("0"));
                titleEntity.setStartYear(fields[5]);
                titleEntity.setEndYear(fields[6]);
                titleEntity.setRuntimeMinutes(fields[7].equals("\\N") ? 0 : Integer.parseInt(fields[7]));

                String genresStr = fields[8].equals("\\N") ? "" : fields[8];
                titleEntity.setGenres(Arrays.stream(genresStr.split(",")).toList());

                titleRepository.save(titleEntity);
                number++;
                if (number > maxNumberOfRecords)
                    break;
            }
        } catch (IOException e) {
            throw new BadRequestException("read file error"); // todo: dev exception handler
        }
    }




    public void importCrewData(MultipartFile file, int maxNumberOfRecords) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            String line;
            boolean firstLine = true;

            int number = 0;
            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false; // Skip header
                    continue;
                }
                String[] fields = line.split("\t");
                Optional<TitleEntity> titleEntityOptional = titleRepository.findById(fields[0]);

                if (titleEntityOptional.isPresent()){
                    TitleEntity titleEntity = titleEntityOptional.get();

                    String directorsStr = fields[1].equals("\\N") ? "" : fields[1];
                    titleEntity.setDirectors(Arrays.stream(directorsStr.split(",")).toList());

                    String writersStr = fields[2].equals("\\N") ? "" : fields[2];
                    titleEntity.setWriters(Arrays.stream(writersStr.split(",")).toList());

                    titleRepository.save(titleEntity);
                }

                number++;
                if (number > maxNumberOfRecords)
                    break;
            }
        } catch (IOException e) {
            throw new BadRequestException("read file error"); // todo: dev exception handler
        }
    }


    public void importNameData(MultipartFile file, int maxNumberOfRecords) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            String line;
            boolean firstLine = true;

            int number = 0;
            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false; // Skip header
                    continue;
                }
                String[] fields = line.split("\t");
                NameEntity nameEntity = new NameEntity();


                nameEntity.setId(fields[0]);
                nameEntity.setPrimaryName(fields[1]);
                nameEntity.setBirthYear(fields[2]);
                nameEntity.setDeathYear(fields[3]);
                nameEntity.setPrimaryProfession(fields[4]);

                String titlesStr = fields[5].equals("\\N") ? "" : fields[5];
                nameEntity.setKnownForTitles(Arrays.stream(titlesStr.split(",")).toList());

                nameRepository.save(nameEntity);
                number++;
                if (number > maxNumberOfRecords)
                    break;
            }
        } catch (IOException e) {
            throw new BadRequestException("read file error"); // todo: dev exception handler
        }
    }


    public void importRatingData(MultipartFile file, int maxNumberOfRecords) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            String line;
            boolean firstLine = true;

            int number = 0;
            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false; // Skip header
                    continue;
                }
                String[] fields = line.split("\t");
                Optional<TitleEntity> titleEntityOptional = titleRepository.findById(fields[0]);

                if (titleEntityOptional.isPresent()){
                    TitleEntity titleEntity = titleEntityOptional.get();
                    titleEntity.setAverageRating(Double.parseDouble(fields[1]));
                    titleEntity.setNumVotes(Integer.parseInt(fields[2]));

                    titleRepository.save(titleEntity);
                }

                number++;
                if (number > maxNumberOfRecords)
                    break;
            }
        } catch (IOException e) {
            throw new BadRequestException("read file error"); // todo: dev exception handler
        }
    }





}
