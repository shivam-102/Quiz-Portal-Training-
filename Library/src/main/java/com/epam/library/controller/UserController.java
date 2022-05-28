package com.epam.library.controller;

import com.epam.library.DTO.UserDTO;
import com.epam.library.feigns.UserClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/library/users")
public class UserController {
    @Autowired
    UserClients userClients;

    @GetMapping()
    public ResponseEntity<List<UserDTO>> getUsers(){
        return new ResponseEntity<>(userClients.getUsers(),HttpStatus.OK);
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable String username){
        return new ResponseEntity<>(userClients.getUserById(username).getBody(),HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO) {
          return new ResponseEntity<>(userClients.addUser(userDTO).getBody(),HttpStatus.CREATED);
    }

    @PutMapping("/{username}")
    public ResponseEntity<UserDTO> updateBook(@PathVariable("username") String username, @RequestBody UserDTO userDTO){
        return new ResponseEntity<>(userClients.updateBook(username, userDTO).getBody(), HttpStatus.OK);
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<UserDTO> deleteUser(@PathVariable("username") String username) {
        return new ResponseEntity<>(userClients.deleteUser(username).getBody(),HttpStatus.NO_CONTENT);
    }


}
