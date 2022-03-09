package com.project.service.quizservice;

import com.project.dao.QuizDAO;
import com.project.entity.Quiz;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Random;

public class CreateQuizService {
    Random random=new Random();
    EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("Quiz-Portal");
    EntityManager entityManager=entityManagerFactory.createEntityManager();
    QuizDAO quizDAO=QuizDAO.getInstance();
    public boolean createNewQuiz(List<Integer> questionsList){
        int quizCode= findCodeExistence();
        return quizDAO.createQuiz(quizCode,entityManager,questionsList);
    }
    public int findCodeExistence(){
        int uniqueKey = random.nextInt(1000);
        String query="select quiz.id from Quiz quiz where quiz.id=:uniqueId";
        List<Quiz> countCheck=entityManager.createQuery(query).setParameter("uniqueId",uniqueKey).getResultList();
        if(countCheck.size()>0){
            findCodeExistence();
        }
        return uniqueKey;
    }
}
