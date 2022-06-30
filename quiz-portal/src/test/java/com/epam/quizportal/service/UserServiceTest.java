package com.epam.quizportal.service;

import com.epam.quizportal.dao.UserDAO;
import com.epam.quizportal.dao.UserRepository;
import com.epam.quizportal.dto.UserDTO;
import com.epam.quizportal.entity.Quiz;
import com.epam.quizportal.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.*;
import java.util.Optional;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @Mock
    ModelMapper modelMapper;

    @Mock
    UserDAO userDAO;

    @InjectMocks
    UserService userService;

    User user;

    UserDTO userDTO;

    @BeforeEach
    void setUp(){
        user=new User();
        user.setUsername("shivam");
        user.setPassword("123");

        userDTO=new UserDTO();
        userDTO.setUsername("shivam");
        userDTO.setPassword("123");


    }

    @Test
    void verifyUser(){
        when(userRepository.findById("shivam")).thenReturn(Optional.ofNullable(user));
        when(modelMapper.map(user,UserDTO.class)).thenReturn(userDTO);
        assertThat(userService.verifyUser("shivam","123")).isEqualTo(true);


    }

    @Test
    void register() {
        when(modelMapper.map(userDTO, User.class)).thenReturn(user);
        when(userRepository.findById("shivam")).thenReturn(Optional.empty());
        assertThat(userService.register(userDTO)).isEqualTo(true);
        verify(userRepository).save(user);

    }

    @Test
    void loadUserByUsernameInvalid(){
        when(userDAO.findByUsername("shivam")).thenReturn(null);
        assertThrows(UsernameNotFoundException.class,() -> userService.loadUserByUsername("shivam"));
    }
}