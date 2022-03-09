package com.project.service.questionservice;

import com.project.dao.QuestionDAO;
import com.project.entity.Options;
import com.project.entity.Questions;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class AddQuestionService {
    Questions questions=new Questions();
    QuestionDAO questionDAO=new QuestionDAO();
    EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("Quiz-Portal");
    EntityManager entityManager=entityManagerFactory.createEntityManager();
    public boolean addNewQuestion(String question, List<Options> options,String difficulty){
        questions.setQuestion(question);
        questions.setOption(options);
        questions.setDifficulty(difficulty);
        questionDAO.insert(entityManager,questions);
        return true;
    }
}
