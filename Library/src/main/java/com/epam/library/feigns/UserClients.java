package com.epam.library.feigns;

import com.epam.library.DTO.UserDTO;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name="user-service",fallback = UserClientImpl.class)
@LoadBalancerClient(name = "user-service",configuration = UserClientImpl.class)
public interface UserClients {

    @GetMapping()
    public List<UserDTO> getUsers();

    @GetMapping("/{username}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable String username);

    @PostMapping()
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO);

    @PutMapping("/{username}")
    public ResponseEntity<UserDTO> updateBook(@PathVariable("username") String username, @RequestBody UserDTO userDTO);

    @DeleteMapping("/{username}")
    public ResponseEntity<UserDTO> deleteUser(@PathVariable("username") String username);
}
