package com.project.service.quizservice;

import com.project.entity.Questions;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ViewQuizService {
    EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("Quiz-Portal");
    EntityManager entityManager=entityManagerFactory.createEntityManager();
    public List<Questions> display(int code){
        String queryString="select quiz.questionsList from Quiz quiz where quiz.code=:code";
        List<Questions> questionsInThisCode=entityManager.createQuery(queryString).setParameter("code",code).getResultList();
        return questionsInThisCode;
    }
}
