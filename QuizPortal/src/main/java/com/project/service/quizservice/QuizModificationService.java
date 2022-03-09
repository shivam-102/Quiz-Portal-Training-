package com.project.service.quizservice;

import com.project.dao.QuizDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class QuizModificationService {
    EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("Quiz-Portal");
    EntityManager entityManager=entityManagerFactory.createEntityManager();
    QuizDAO quizDAO=new QuizDAO();
    public boolean addQuestion(int code,int questionNumber){
        return quizDAO.addQuestion(entityManager,code,questionNumber);

    }

    public boolean deleteQuestion(int code,int questionNumber){
        return quizDAO.deleteQuestion(entityManager,code,questionNumber);
    }
}
