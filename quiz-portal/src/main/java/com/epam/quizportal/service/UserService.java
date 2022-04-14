package com.epam.quizportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.quizportal.dao.UserDAO;
import com.epam.quizportal.entity.User;

@Service
public class UserService {
	/*
	@Autowired
	UserDAO userDAO;
	
	public boolean verifyUser(String userName,String password) {
		User user=userDAO.userCredentialVerification(userName, password);
		if(user!=null) {
			return true;
		}
		return false;
	}
	
	public boolean registerNewUser(User user) {
		return userDAO.addNewUser(user);
	}

	 */
}
