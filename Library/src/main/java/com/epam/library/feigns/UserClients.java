package com.epam.library.feigns;

import com.epam.library.DTO.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(url = "http://localhost:9091/users/",value = "user-service")
public interface UserClients {

    @GetMapping()
    public ResponseEntity<List<UserDTO>> getUsers();

    @GetMapping("/{username}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable String username);

    @PostMapping()
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO);

    @PutMapping("/{username}")
    public ResponseEntity<UserDTO> updateBook(@PathVariable("username") String username, @RequestBody UserDTO userDTO);

    @DeleteMapping("/{username}")
    public ResponseEntity<UserDTO> deleteUser(@PathVariable("username") String username);




}
