package com.casinotest.casino_api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.casinotest.casino_api.controller.UserController;
import com.casinotest.casino_api.model.User;
import com.casinotest.casino_api.service.UserService;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void testGetUser() throws Exception {
        // Mock the behavior of the userService.getUser method
        when(userService.getUser("1")).thenReturn(new User("TestUser", 100));

        mockMvc.perform(get("/api/user/{userId}", "1"))
               .andExpect(status().isOk());
    }

    // Add more test cases as needed
}
