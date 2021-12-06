package com.example.jenkinstest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@SpringBootTest
@AutoConfigureMockMvc
class JenkinsTestApplicationTests {
    @Autowired
    private MockMvc mockMvc;
    @Test
    void shouldReturnDefaultMessage() throws Exception{
        RequestBuilder request = MockMvcRequestBuilders.get("/");
        ResultHandler result = MockMvcResultHandlers.print();
        ResultMatcher resultMatcher = MockMvcResultMatchers.status().isOk();
        ResultMatcher resultMatcherb = MockMvcResultMatchers.content().string("Hello World");
        mockMvc
                .perform(request)
                .andDo(result)
                .andExpect(resultMatcher)
                .andExpect(resultMatcherb);
    }
}