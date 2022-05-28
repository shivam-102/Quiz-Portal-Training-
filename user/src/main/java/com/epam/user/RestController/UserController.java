package com.epam.user.RestController;


import com.epam.user.DTO.UserDTO;
import com.epam.user.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping()
    public ResponseEntity<List<UserDTO>> getUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable("username") String username){
        return new ResponseEntity<>(userService.getUserById(username),HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO){
        return new ResponseEntity<>(userService.addNewUser(userDTO),HttpStatus.CREATED);
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<String> deleteUser(@PathVariable("username") String username){
        userService.deleteUser(username);
        return new ResponseEntity<>("User deleted successfully!",HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{username}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable("username") String username, @RequestBody UserDTO userDTO){
        return new ResponseEntity<>(userService.updateUser(username,userDTO),HttpStatus.OK);
    }

}
