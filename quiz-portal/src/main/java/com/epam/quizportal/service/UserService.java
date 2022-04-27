package com.epam.quizportal.service;

import com.epam.quizportal.dao.UserDAO;
import com.epam.quizportal.dao.UserRepository;
import com.epam.quizportal.dto.UserDTO;
import com.epam.quizportal.dto.UserPrincipal;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.epam.quizportal.entity.User;

import java.util.Optional;

@Service
@EnableWebSecurity
public class UserService implements UserDetailsService {


	@Autowired
	UserDAO userDAO;
	@Autowired
	UserRepository userRepository;

	@Autowired
	ModelMapper modelMapper;

	public boolean verifyUser(String userName, String password){
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
	    boolean status=false;
		if(fetchUser.isEmpty()){
			PasswordEncoder encoder=new BCryptPasswordEncoder(9);
			user.setPassword(encoder.encode(user.getPassword()));
			userRepository.save(modelMapper.map(user,User.class));
			status=true;
		}
		return status;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("Username"+username);
		User user=userDAO.findByUsername(username);
		System.out.println(user.toString());

		if(user==null){
			throw new UsernameNotFoundException("User not registered");

		}
		return new UserPrincipal(user);


	}
}
