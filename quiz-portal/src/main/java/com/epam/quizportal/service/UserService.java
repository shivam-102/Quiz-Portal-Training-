package com.epam.quizportal.service;

import com.epam.quizportal.dao.UserRepository;
import com.epam.quizportal.dto.UserDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.epam.quizportal.entity.User;

import java.util.Optional;

@Service
public class UserService {



	@Autowired
	UserRepository userRepository;

	@Autowired
	ModelMapper modelMapper;

	public boolean verify(String userName,String password){
		Optional<User> userValidation=userRepository.findById(userName);
		Boolean flag=false;
		if(userValidation.isPresent()){

			UserDTO user=modelMapper.map(userValidation.get(),UserDTO.class);
			if(user.getPassword().equals(password)){
				flag=true;
			}

		}
		return flag;
	}

	public boolean register(UserDTO user){
		Optional<User> fetchUser=userRepository.findById(user.getUsername());
	    Boolean status=true;
		if(fetchUser.isEmpty()){
			userRepository.save(modelMapper.map(user,User.class));
			status=false;
		}
		return status;
	}

}
