package com.epam.library.Controller;

import com.epam.library.DTO.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
@RequestMapping("/library/users")
public class UserController {
    HttpHeaders httpHeaders=new HttpHeaders();

    @Autowired
    RestTemplate restTemplate;

    String USER_BASE_URL="http://localhost:9091/users/";

    @GetMapping()
    public String getUsers(){
        return restTemplate.exchange(USER_BASE_URL, HttpMethod.GET,null,String.class).getBody();
    }

    //ParameterTypeReference
    @GetMapping("/{username}")
    public String getUserById(@PathVariable String username){
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity=new HttpEntity<>(httpHeaders);
        return restTemplate.exchange(USER_BASE_URL+username,HttpMethod.GET,entity,String.class).getBody();
    }

    @PostMapping()
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO) {
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity <UserDTO> entity = new HttpEntity<>(userDTO,httpHeaders);
        return new ResponseEntity<UserDTO>(restTemplate.exchange(USER_BASE_URL, HttpMethod.POST, entity, UserDTO.class).getBody(), HttpStatus.CREATED);
    }

    @PutMapping("/{username}")
    public ResponseEntity<UserDTO> updateBook(@PathVariable("username") String username, @RequestBody UserDTO userDTO){
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<UserDTO> entity=new HttpEntity<>(userDTO,httpHeaders);
        return new ResponseEntity<UserDTO>(restTemplate.exchange(USER_BASE_URL+username,HttpMethod.PUT,entity, UserDTO.class).getBody(),HttpStatus.OK);

    }

    @DeleteMapping("/{username}")
    public ResponseEntity<UserDTO> deleteUser(@PathVariable("username") String username){
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<UserDTO> entity=new HttpEntity<>(httpHeaders);
        return new ResponseEntity<UserDTO>(restTemplate.exchange(USER_BASE_URL+username,HttpMethod.DELETE,entity,UserDTO.class).getBody(),HttpStatus.NO_CONTENT);
    }


}
