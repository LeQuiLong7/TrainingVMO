package com.lql.springdemo.controller;

import com.lql.springdemo.exception.model.UserNotFoundException;
import com.lql.springdemo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(UserController.class)
@AutoConfigureMockMvc
class UserControllerTest {

    @MockBean
    private UserService userService;

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void userNotFoundExceptionHandlerTest() throws Exception {
        String username = "username1";
        when(userService.findByUserName(username))
                .thenThrow(new UserNotFoundException(username));


        String baseURL = UserController.class.getAnnotation(RequestMapping.class).value()[0];
        String requestMapping = "/username/" + username;

        mockMvc.perform(get(baseURL + requestMapping)

        ).andExpectAll(
                status().isBadRequest(),
                jsonPath("$.error").exists(),
                jsonPath("$.error").value("Can not find user with username: " + username),
                jsonPath("$.time_stamp").exists()
        ).andDo(print());
    }
}