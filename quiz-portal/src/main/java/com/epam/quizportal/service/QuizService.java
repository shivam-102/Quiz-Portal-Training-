package com.epam.quizportal.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.epam.quizportal.dao.QuestionRepository;
import com.epam.quizportal.dao.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.quizportal.dao.QuizDAO;
import com.epam.quizportal.entity.Questions;
import com.epam.quizportal.entity.Quiz;

@Service
public class QuizService {

    @Autowired
    QuizRepository quizRepository;

    @Autowired
    QuestionRepository questionRepository;

    Random random=new Random();


    public Quiz viewQuiz(Integer code){
        Optional<Quiz> quiz=quizRepository.findById(code);
        if(quiz.isPresent()){
            Quiz quizQuestions=quiz.get();
            return quizQuestions;
        }

        return null;
    }
    public boolean createQuiz(List<Integer> questionIdList){
        Integer uniqueKey=findCodeExistence();
        Quiz quiz=new Quiz();
        quiz.setCode(uniqueKey);
        List<Questions> questionsList=questionRepository.findAllById(questionIdList);
        quiz.setQuestionsList(questionsList);
        quizRepository.save(quiz);
        return false;
    }

    public Integer findCodeExistence(){
        int uniqueKey = random.nextInt(1000);
        Optional<Quiz> quizExistence=quizRepository.findById(uniqueKey);
        if(quizExistence.isPresent()){
            findCodeExistence();
        }
        return uniqueKey;
    }
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
