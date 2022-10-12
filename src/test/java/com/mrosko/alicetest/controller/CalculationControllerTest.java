package com.mrosko.alicetest.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CalculationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ResourceLoader resourceLoader;

    @Test
    void whenCalculate_andEmptyDataProvided_thenReturn400() throws Exception {
        mockMvc.perform(post("/calculation")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("[{}]"))
                .andExpect(status().is(400));
    }

    @Test
    void whenCalculate_andValidDataProvided_thenReturnBody() throws Exception {

        mockMvc.perform(post("/calculation")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(readFile("controller/firstRequest.json")))
                .andExpect(status().is(200))
                .andExpect(content().json(readFile("controller/firstResponse.json")));
    }

    private String readFile(String path) throws Exception {

        Resource resource = resourceLoader.getResource("classpath:" + path);
        return FileCopyUtils.copyToString(new InputStreamReader(resource.getInputStream(), UTF_8));
    }

}
