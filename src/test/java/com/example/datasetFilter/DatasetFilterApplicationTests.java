package com.example.datasetFilter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class DatasetFilterApplicationTests {

	@Autowired
	private MockMvc mockMvc;


	private void filterGetData(String method) throws Exception {
		mockMvc.perform(get("/api/v1/filter/" + method)
				)
				.andExpect(status().isOk());
	}

	private void filterPostData(String method, String jsonContent) throws Exception {
		mockMvc.perform(post("/api/v1/filter/" + method)
						.contentType(MediaType.APPLICATION_JSON)
						.content(jsonContent)
				)
				.andExpect(status().isOk());
	}


	@Test
	void filterTitlesWhereDirectorAndWriterAreSame() throws Exception {
		filterGetData("get-director-writer-same"
		);
	}



}
