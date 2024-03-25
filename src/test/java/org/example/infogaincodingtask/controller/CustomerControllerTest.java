package org.example.infogaincodingtask.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:/dbpopulate.sql"},executionPhase = Sql.ExecutionPhase.BEFORE_TEST_CLASS)
public class CustomerControllerTest {
    private final String mockJsonResponse150Points = "{\"totalPoints\":150,\"transactionList\":[{\"transactionId\":1,\"transactionDate\":\"2024-03-25\",\"transactionAmount\":150},{\"transactionId\":2,\"transactionDate\":\"2024-03-22\",\"transactionAmount\":50},{\"transactionId\":3,\"transactionDate\":\"2024-02-01\",\"transactionAmount\":10}]}";
    private final String mockJsonResponse10Points = "{\"totalPoints\":10,\"transactionList\":[{\"transactionId\":5,\"transactionDate\":\"2024-03-25\",\"transactionAmount\":10},{\"transactionId\":6,\"transactionDate\":\"2024-03-25\",\"transactionAmount\":60}]}";
    private final String mockJsonResponse0Points = "{\"totalPoints\":0,\"transactionList\":[{\"transactionId\":7,\"transactionDate\":\"2024-03-25\",\"transactionAmount\":49}]}";

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
    }

    @Test
    public void shouldReturnNonEmptyListOfCustomers() throws Exception {
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/customer")).andExpect(status().isOk());
        System.out.println(resultActions.andReturn().getResponse().getContentAsString());
    }

    @Test
    public void shouldReturn150Points() throws Exception {
        int customerId = 1;
        mockMvc.perform(MockMvcRequestBuilders.get("/customer/points/" + customerId)).andExpect(status().isOk()).andExpect(content().json(mockJsonResponse150Points));
    }

    @Test
    public void shouldReturn10Points() throws Exception {
        int customerId = 2;
        mockMvc.perform(MockMvcRequestBuilders.get("/customer/points/" + customerId)).andExpect(status().isOk()).andExpect(content().json(mockJsonResponse10Points));
    }

    @Test
    public void shouldReturn0Points() throws Exception {
        int customerId = 3;
        mockMvc.perform(MockMvcRequestBuilders.get("/customer/points/" + customerId)).andExpect(status().isOk()).andExpect(content().json(mockJsonResponse0Points));
    }

}
