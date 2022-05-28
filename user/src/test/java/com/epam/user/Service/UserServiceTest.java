package com.epam.user.Service;

import com.epam.user.DAO.UserRepository;
import com.epam.user.DTO.UserDTO;
import com.epam.user.Entity.Users;
import com.epam.user.Exception.UserExistsException;
import org.apache.catalina.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @Mock
    ModelMapper modelMapper;

    @InjectMocks
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
    void getAllUsers() {
        when(userRepository.findAll()).thenReturn(usersList);
        assertThat(userService.getAllUsers()).isEqualTo(null);
        verify(userRepository).findAll();
    }

    @Test
    void getUserById() {
        when(userRepository.findById("shivam")).thenReturn(Optional.ofNullable(user));
        when(modelMapper.map(user,UserDTO.class)).thenReturn(userDTO);
        assertThat(userService.getUserById("shivam")).isEqualTo(userDTO);
        verify(userRepository).findById("shivam");

    }

    @Test
    void addNewUser() {
        when(userRepository.save(user)).thenReturn(user);
        when(modelMapper.map(userDTO,Users.class)).thenReturn(user);
        when(modelMapper.map(user,UserDTO.class)).thenReturn(userDTO);
        assertThat(userService.addNewUser(userDTO)).isEqualTo(userDTO);
        verify(userRepository).save(user);
    }

    @Test
    void deleteUser() {
        when(userRepository.findById("shivam")).thenReturn(Optional.of(user));
        assertThat(userService.deleteUser("shivam")).isEqualTo(true);
        verify(userRepository,times(1)).deleteById("shivam");
    }



    @Test
    void updateUser() {
        when(userRepository.findById("shivam")).thenReturn(Optional.ofNullable(user));
        when(userService.updateUser("shivam",userDTO)).thenReturn(userDTO);
        assertThat(userService.updateUser("shivam",userDTO)).isEqualTo(userDTO);

    }
}