package com.epam.quizportal.service;

import com.epam.quizportal.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.epam.quizportal.entity.User;

import java.util.Optional;

@Service
public class UserService {



	@Autowired
	UserRepository userRepository;

	public boolean verify(String userName,String password){
		Optional<User> userValidation=userRepository.findById(userName);
		Boolean flag=false;
		if(userValidation.isPresent()){
			User user=userValidation.get();
			if(user.getPassword().equals(password)){
				flag=true;
			}

		}
		return flag;
	}

	public boolean register(User user){
		Optional<User> fetchUser=userRepository.findById(user.getUsername());
	    Boolean status=true;
		if(fetchUser.isEmpty()){
			userRepository.save(user);
			status=false;
		}
		return status;
	}
	/*
	
	public boolean verifyUser(String userName,String password) {
		User user=userDAO.userCredentialVerification(userName, password);
		if(user!=null) {
			return true;
		}
		return false;
	}

	public boolean register(User user){
		Optional<User> fetchUser=userRepository.findById(user.getUsername());
		boolean status=false;
		if(fetchUser.isEmpty()){
			userRepository.save(user);
			status=true;
		}
		return status;
	}
	public boolean registerNewUser(User user) {
		return userDAO.addNewUser(user);
	}

	 */


}
