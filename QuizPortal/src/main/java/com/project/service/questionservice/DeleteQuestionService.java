package com.project.service.questionservice;

import com.project.dao.QuestionDAO;
import com.project.entity.Questions;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DeleteQuestionService {
    EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("Quiz-Portal");
    EntityManager entityManager=entityManagerFactory.createEntityManager();
    QuestionDAO questionDAO=QuestionDAO.getInstance();
    public boolean deleteOperation(int questionToBeDeleted){
        Questions question=entityManager.find(Questions.class,questionToBeDeleted);
        return questionDAO.delete(entityManager,question);
    }
}
