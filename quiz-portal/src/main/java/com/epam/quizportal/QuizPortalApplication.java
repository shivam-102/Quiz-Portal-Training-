package com.epam.quizportal;
import com.epam.quizportal.dao.AuthGroupRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Random;


@SpringBootApplication
public class QuizPortalApplication implements CommandLineRunner {

	@Autowired
	AuthGroupRepository authGroupRepository;

	public static void main(String[] args) {
		SpringApplication.run(QuizPortalApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	@Bean
	public Random random(){return new Random();}



	@Override
	public void run(String... args) throws Exception {
//		AuthGroup auth=new AuthGroup();
//		auth.setUsername("abc");
//		auth.setAuthGroup("ADMIN");
//		authGroupRepository.save(auth);

	}
}
