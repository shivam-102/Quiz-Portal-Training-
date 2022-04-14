package com.epam.quizportal.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.quizportal.dao.QuizDAO;
import com.epam.quizportal.entity.Questions;
import com.epam.quizportal.entity.Quiz;

@Service
public class QuizService {
	/*
	EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("Quiz-Portal");
    EntityManager entityManager=entityManagerFactory.createEntityManager();
	
	@Autowired
	QuizDAO quizDAO;
	
	public boolean createQuizService(List<Integer> questionsList) {
		int uniqueCode=uniqueQuizCode();
		return quizDAO.createQuiz(uniqueCode,entityManager,questionsList);

	}
	
	public int uniqueQuizCode() {
		return quizDAO.findCodeExistence();
	}
	
	
	public Quiz viewQuizQuestions(int code){
		return quizDAO.questionsInTheQuiz(code);
	}
	
	public boolean addQuestion(int code,int questionNumber){
        return quizDAO.addQuestion(code,questionNumber);

    }

    public boolean deleteQuestion(int code,int questionNumber){
        return quizDAO.deleteQuestion(code,questionNumber);
    }



	 */
}
