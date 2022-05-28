package com.epam.library.controller;

import com.epam.library.DTO.UserDTO;
import com.epam.library.feigns.UserClients;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@SpringBootTest()
class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    UserClients userClients;


    UserDTO userDTO;

    List<UserDTO> userDTOList;


    @BeforeEach
    void setUp(){
        userDTO=new UserDTO();
        userDTO.setUsername("shivam");
        userDTO.setEmail("shivam@123.com");
        userDTO.setName("Shivam");
        userDTOList=new ArrayList<>();
        userDTOList.add(userDTO);
    }

    @Test
    void getUsersTest() throws Exception {
        when(userClients.getUsers()).thenReturn(userDTOList);
        String jsonExpression=new ObjectMapper().writeValueAsString(userDTOList);
        mockMvc.perform(get("/library/users").contentType(MediaType.APPLICATION_JSON).contentType(jsonExpression)).andExpect(status().isOk());
    }

    @Test
    void getUserById() throws Exception {
        when(userClients.getUserById("shivam")).thenReturn(new ResponseEntity<>(userDTO, HttpStatus.OK));
        String jsonExpression=new ObjectMapper().writeValueAsString(userDTO);
        mockMvc.perform(get("/library/users/shivam").contentType(MediaType.APPLICATION_JSON).contentType(jsonExpression)).andExpect(status().isOk());
    }

    @Test
    void addUser() throws Exception {
        when(userClients.addUser(userDTO)).thenReturn(new ResponseEntity<>(userDTO,HttpStatus.CREATED));
        String jsonExpression=new ObjectMapper().writeValueAsString(userDTO);
        mockMvc.perform(post("/library/users").contentType(MediaType.APPLICATION_JSON).contentType(jsonExpression)).andExpect(status().isCreated());
    }

    @Test
    void updateBook() throws Exception {
        when(userClients.updateBook("shivam",userDTO)).thenReturn(new ResponseEntity<>(userDTO,HttpStatus.OK));
        String jsonExpression=new ObjectMapper().writeValueAsString(userDTO);
        mockMvc.perform(put("/library/users/shivam").contentType(MediaType.APPLICATION_JSON).contentType(jsonExpression)).andExpect(status().isOk());
    }

    @Test
    void deleteUser() throws Exception {
        when(userClients.deleteUser("shivam")).thenReturn(new ResponseEntity<>(userDTO,HttpStatus.NO_CONTENT));
        String jsonExpression=new ObjectMapper().writeValueAsString(userDTO);
        mockMvc.perform(delete("/library/users/shivam").contentType(MediaType.APPLICATION_JSON).contentType(jsonExpression)).andExpect(status().isNoContent());
    }
}