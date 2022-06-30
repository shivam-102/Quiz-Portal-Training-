package com.epam.quizportal.controller;

import com.epam.quizportal.dto.AuthenticationRequest;
import com.epam.quizportal.util.JwtUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = AuthenticationApiController.class)
@AutoConfigureMockMvc(addFilters = false)
@EnableWebMvc
class AuthApiControllerTest {
    @Mock
    AuthenticationRequest authenticationRequest;
    @Autowired
    MockMvc mockMvc;
    @MockBean
    private AuthenticationManager authenticationManager;
    @MockBean
    private JwtUtil jwtUtil;

    @MockBean
    private UserDetailsService userDetailsService;


    @Test
    void createTokenValidTest() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        AuthenticationRequest authenticationRequest1 = new AuthenticationRequest();
        authenticationRequest1.setUsername("danish");
        authenticationRequest1.setPassword("1234");
        Mockito.when(authenticationRequest.getUsername()).thenReturn("danish");
        Mockito.when(authenticationRequest.getPassword()).thenReturn("1234");
        mockMvc.perform(post("/authenticate").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(authenticationRequest1)))
                .andExpect(status().isOk());
    }

    @Test
    void createTokenInvalidTest() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        AuthenticationRequest authenticationRequest1 = new AuthenticationRequest();
        authenticationRequest1.setUsername("danish");
        authenticationRequest1.setPassword("1234");
        Mockito.when(authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest1.getUsername(), authenticationRequest1.getPassword())))
                .thenThrow(new BadCredentialsException("Incorrect Username or Password"));
        Assertions
                .assertThatThrownBy(
                        () -> mockMvc.perform(post("/authenticate").contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(authenticationRequest1))))
                .hasCauseInstanceOf(Exception.class).hasMessageContaining("Incorrect Username or Password");
    }
}