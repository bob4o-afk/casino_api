// src/test/java/com/casinotest/casino_api/UserControllerTest.java

package com.casinotest.casino_api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetUser() throws Exception {
        mockMvc.perform(get("/api/users/{userId}", 1L))
               .andExpect(status().isOk());
    }

    // Add more test cases as needed
}
