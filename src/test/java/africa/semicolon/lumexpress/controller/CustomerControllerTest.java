package africa.semicolon.lumexpress.controller;

import africa.semicolon.lumexpress.data.dto.request.CustomerRegistrationRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
class CustomerControllerTest {
    private CustomerRegistrationRequest request;
    @Autowired
    private MockMvc mockMvc;
    @BeforeEach
    void setUp() {

        request  = CustomerRegistrationRequest
                .builder()
                .email("john@gmail.com")
                .password("johnny400")
                .country("Nigeria")
                .build();
    }

    @Test
    void registerControllerTest() throws Exception {
        ObjectMapper  mapper  =  new ObjectMapper();
        mockMvc.perform(MockMvcRequestBuilders
                .post("/api/v1/customer")
                .contentType("application/json")
                .content(mapper.writeValueAsString(request)))
                .andExpect(MockMvcResultMatchers.status().is(201))
                .andDo(MockMvcResultHandlers.print());




    }
}