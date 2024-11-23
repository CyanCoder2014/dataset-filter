package com.example.datasetFilter;

import com.example.datasetFilter.entity.NameEntity;
import com.example.datasetFilter.entity.TitleEntity;
import com.example.datasetFilter.repository.NameRepository;
import com.example.datasetFilter.repository.TitleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.*;

import java.util.List;


@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DatasetFilterApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TitleRepository titleRepository;
    @Autowired
    private NameRepository nameRepository;


    @BeforeAll
    void addTestData() {
        titleRepository.save(TitleEntity.builder()
                .id("11").primaryTitle("title1").directors(List.of("1")).writers(List.of("2"))
                .build());

        titleRepository.save(TitleEntity.builder()
                .id("22").primaryTitle("title2").directors(List.of("2")).writers(List.of("1"))
                .build());


        nameRepository.save(NameEntity.builder()
                .id("1").primaryName("Fred Astaire3").deathYear("/N").knownForTitles(List.of("11"))
                .build());
        nameRepository.save(NameEntity.builder()
                .id("2").primaryName("Lauren Bacall3").deathYear("/N").knownForTitles(List.of("11"))
                .build());
    }

    private void filterGetDataReturn200(String method) throws Exception {
        mockMvc.perform(get("/api/v1/filter/" + method)
                )
                .andExpect(status().isOk());
    }

    private void filterPostDataReturn200(String method, String jsonContent) throws Exception {
        mockMvc.perform(post("/api/v1/filter/" + method)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonContent)
                )
                .andExpect(status().isOk());
    }

    private void filterPostDataReturn400(String method, String jsonContent) throws Exception {
        mockMvc.perform(post("/api/v1/filter/" + method)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonContent)
                )
                .andExpect(status().isBadRequest());
    }


    @Test
    void filterTitlesWhereDirectorAndWriterAreSameReturn200() throws Exception {
        filterGetDataReturn200("get-director-writer-same"
        );
    }


    @Test
    void filterByActorsReturn200() throws Exception {
        filterPostDataReturn200("filter-by-actors",

                "{\n" +
                        "    \"actor1\": \"Fred Astaire3\",\n" +
                        "    \"actor2\": \"Lauren Bacall3\"\n" +
                        "}"
        );
    }

    @Test
    void filterByActorsReturn400() throws Exception {
        filterPostDataReturn400("filter-by-actors",

                "{\n" +
                        "    \"actor1\": \"Fred Astairrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrre\",\n" +
                        "    \"actor2\": \"Lauren Bacall\"\n" +
                        "}"
        );
    }


    @AfterAll
    void deleteTestData() {
        titleRepository.delete(TitleEntity.builder()
                .id("1").primaryTitle("title1").directors(List.of("1")).writers(List.of("1"))
                .build());

        titleRepository.delete(TitleEntity.builder()
                .id("2").primaryTitle("title2").directors(List.of("1")).writers(List.of("1"))
                .build());


        nameRepository.delete(NameEntity.builder()
                .id("1").primaryName("Fred Astaire3").deathYear("/N").knownForTitles(List.of("1"))
                .build());
        nameRepository.delete(NameEntity.builder()
                .id("2").primaryName("Lauren Bacall3").deathYear("/N").knownForTitles(List.of("1"))
                .build());
    }



}
