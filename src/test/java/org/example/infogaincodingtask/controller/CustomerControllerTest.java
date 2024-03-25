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
@Sql(scripts = {"classpath:/dbpopulate.sql"})
public class CustomerControllerTest {
    private final String mockJsonResponse = "{\"totalPoints\":150,\"transactionList\":[{\"transactionId\":1,\"transactionDate\":\"2024-03-25\",\"transactionAmount\":150},{\"transactionId\":2,\"transactionDate\":\"2024-03-22\",\"transactionAmount\":50},{\"transactionId\":3,\"transactionDate\":\"2024-02-01\",\"transactionAmount\":10}]}";

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
    public void shouldReturnPoints() throws Exception {
        int customerId = 1;
        mockMvc.perform(MockMvcRequestBuilders.get("/customer/points/" + customerId)).andExpect(status().isOk()).andExpect(content().json(mockJsonResponse));
    }

}
