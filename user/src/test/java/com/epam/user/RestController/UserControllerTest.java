package com.epam.user.RestController;

import com.epam.user.DTO.UserDTO;
import com.epam.user.Entity.Users;
import com.epam.user.Service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.http.MediaType;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import java.util.ArrayList;
import java.util.List;


@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    UserService userService;

    Users user;

    UserDTO userDTO;

    List<Users> usersList;

    List<UserDTO> userDTOList;


    @BeforeEach
    void setUp(){
        user=new Users();
        user.setUsername("shivam");
        user.setEmail("shivam@123.com");
        user.setName("Shivam");

        userDTO=new UserDTO();
        userDTO.setUsername("shivam");
        userDTO.setEmail("shivam@123.com");
        userDTO.setName("Shivam");

        usersList=new ArrayList<>();
        usersList.add(user);

        userDTOList=new ArrayList<>();
        userDTOList.add(userDTO);
    }

    @Test
    void getUsers() throws Exception {
        when(userService.getAllUsers()).thenReturn(userDTOList);
        String jsonExpression=new ObjectMapper().writeValueAsString(userDTOList);
        mockMvc.perform(get("/users").contentType(MediaType.APPLICATION_JSON).content(jsonExpression)).andExpect(status().isOk());
    }

    @Test
    void getUserById() throws Exception {
        when(userService.getUserById("shivam")).thenReturn(userDTO);
        String jsonExpression=new ObjectMapper().writeValueAsString(userDTO);
        mockMvc.perform(get("/users/shivam").contentType(MediaType.APPLICATION_JSON).contentType(jsonExpression)).andExpect(status().isOk());

    }

    @Test
    void addUser() throws Exception {
        when(userService.addNewUser(userDTO)).thenReturn(userDTO);
        String jsonExpression=new ObjectMapper().writeValueAsString(userDTO);
        mockMvc.perform(post("/users").contentType(MediaType.APPLICATION_JSON).content(jsonExpression)).andExpect(status().isCreated());
    }

    @Test
    void deleteUser() throws Exception {
        when(userService.deleteUser("shivam")).thenReturn(true);
        String jsonExpression=new ObjectMapper().writeValueAsString(true);
        mockMvc.perform(delete("/users/shivam").contentType(MediaType.APPLICATION_JSON).contentType(jsonExpression)).andExpect(status().isNoContent());

    }

    @Test
    void updateUser() throws Exception {
        when(userService.updateUser("shivam",userDTO)).thenReturn(userDTO);
        String jsonExpression=new ObjectMapper().writeValueAsString(userDTO);
        mockMvc.perform(put("/users/shivam").contentType(MediaType.APPLICATION_JSON).content(jsonExpression)).andExpect(status().isOk());

    }
}