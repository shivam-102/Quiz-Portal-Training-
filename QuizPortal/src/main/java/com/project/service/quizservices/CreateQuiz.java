package com.project.service.quizservices;
import com.project.dao.QuizDAO;
import com.project.service.Operation;
import com.project.ui.quizui.CreateQuizUI;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Scanner;
@Setter
public class CreateQuiz implements Operation {
    private Logger logger= LogManager.getLogger(CreateQuiz.class);
    QuizDAO quizDAO=QuizDAO.getInstance();
    Scanner scanner=new Scanner(System.in);
     int numberOfQuestions;
    CreateQuizUI createQuizUI=new CreateQuizUI();
    EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("Quiz-Portal");
    EntityManager entityManager=entityManagerFactory.createEntityManager();
    @Override
    public void perform() {
        countOfQuestions();
        logger.info("Provide the question numbers you want to add into the quiz:");
        if(addQuestions()){
            logger.info("Quiz has been created successfully;");
        }
        logger.info("Quiz cannot be created");

    }
    void countOfQuestions(){
        logger.info("How many questions you want to keep in the quiz?");
        setNumberOfQuestions(createQuizUI.numberOfQuestion());
    }
    boolean addQuestions(){
        logger.info("Provide the question numbers you want to add into the quiz:");
        List<Integer> toAdd=createQuizUI.questionsToBeAdded(numberOfQuestions);
        //quizDAO.createQuiz(entityManager,toAdd);
        return true;
    }
}
