package com.epam.quizportal;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Random;


@SpringBootApplication
public class QuizPortalApplication  {

	public static void main(String[] args) {
		SpringApplication.run(QuizPortalApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	@Bean
	public Random random(){return new Random();}
}
