package com.epam.library.feigns;

import com.epam.library.DTO.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class UserClientImpl implements UserClients{
    @Override
    public List<UserDTO> getUsers() {
        return Arrays.asList(new UserDTO("","",""));
    }

    @Override
    public ResponseEntity<UserDTO> getUserById(String username) {
        return new ResponseEntity<>(new UserDTO("","",""), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserDTO> addUser(UserDTO userDTO) {
        return new ResponseEntity<>(new UserDTO("","",""), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserDTO> updateBook(String username, UserDTO userDTO) {
        return new ResponseEntity<>(new UserDTO("","",""), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserDTO> deleteUser(String username) {
        return new ResponseEntity<>(new UserDTO("","",""), HttpStatus.NO_CONTENT);
    }
}
