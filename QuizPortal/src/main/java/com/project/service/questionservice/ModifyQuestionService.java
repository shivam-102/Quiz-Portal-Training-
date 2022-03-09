package com.project.service.questionservice;

import com.project.dao.QuestionDAO;
import com.project.entity.Options;
import com.project.entity.Questions;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ModifyQuestionService {
    QuestionDAO questionDAO=QuestionDAO.getInstance();
    EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("Quiz-Portal");
    EntityManager entityManager=entityManagerFactory.createEntityManager();
    public boolean modifyQuestion(int questionToBeModified,String newQuestion){
        Questions questionToModify=entityManager.find(Questions.class,questionToBeModified);
        return questionDAO.modifyQuestion(entityManager,newQuestion,questionToModify);

    }

    public boolean modifyOptions(int questionToBeModified, List<Options> newOptions){
        Questions optionToModify=entityManager.find(Questions.class,questionToBeModified);
        return questionDAO.modifyOptions(entityManager,newOptions,optionToModify);
    }

    public boolean modifyDifficulty(int questionToBeModified,String newDifficulty){
        Questions difficultyToModify=entityManager.find(Questions.class,questionToBeModified);
        return questionDAO.modifyDifficulty(entityManager,newDifficulty,difficultyToModify);
    }
}
