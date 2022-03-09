package com.project.service.quizservice;

import com.project.entity.Questions;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ViewQuestionBankService {
    EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("Quiz-Portal");
    EntityManager entityManager=entityManagerFactory.createEntityManager();
    public List<Questions> display(){
        List<Questions> questionsToDisplay = entityManager.createQuery("select new com.project.entity.Questions(q.id,q.question,q.difficulty) from Questions q", Questions.class)
                .getResultList();
        return questionsToDisplay;
    }
}
