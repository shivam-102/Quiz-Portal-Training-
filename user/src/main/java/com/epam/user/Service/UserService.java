package com.epam.user.Service;

import com.epam.user.DAO.UserRepository;
import com.epam.user.DTO.UserDTO;
import com.epam.user.Entity.Users;
import com.epam.user.Exception.UserDoesNotExistException;
import com.epam.user.Exception.UserExistsException;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ModelMapper modelMapper;

    public List<UserDTO> getAllUsers(){
        Type listType=new TypeToken<List<UserDTO>>(){}.getType();
        return modelMapper.map(userRepository.findAll(),listType);
    }

    public UserDTO getUserById(String userName){
        Optional<Users> optionalUsers=userRepository.findById(userName);
        Users user=optionalUsers.orElseThrow( ()-> new UserDoesNotExistException());
        return modelMapper.map(user,UserDTO.class);
    }

    public UserDTO addNewUser(UserDTO userDTO){
        Optional<Users> optionalUser=userRepository.findById(userDTO.getUsername());
        if(optionalUser.isPresent()){
            throw new UserExistsException();
        }
        Users user=userRepository.save(modelMapper.map(userDTO,Users.class));
        return modelMapper.map(user,UserDTO.class);
    }

    public boolean deleteUser(String userName){
        Optional<Users> optionalUsers=userRepository.findById(userName);
        Users user=optionalUsers.orElseThrow( ()-> new UserDoesNotExistException());
        userRepository.deleteById(userName);
        return true;
    }

    public UserDTO updateUser(String userId,UserDTO userDTO){
        Optional<Users> optionalUsers=userRepository.findById(userId);
        Users user=optionalUsers.orElseThrow( ()-> new UserDoesNotExistException());
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        return modelMapper.map(user,UserDTO.class);
    }


}
