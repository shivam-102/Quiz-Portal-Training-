package com.project.service.questionservices;
import com.project.dao.QuestionDAO;
import com.project.entity.Questions;
import com.project.service.Operation;
import com.project.ui.questionui.DeleteQuestionUI;
import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DeleteQuestion implements Operation {
    private static Logger logger = LogManager.getLogger(DeleteQuestion.class);
    QuestionDAO questionDAO = QuestionDAO.getInstance();
    DeleteQuestionUI deleteQuestionUI = new DeleteQuestionUI();
    EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("Quiz-Portal");
    EntityManager entityManager=entityManagerFactory.createEntityManager();
    @Getter
    @Setter
    private int toBeDeleted;
    @Override
    public void perform() {
        setParameters();
        Questions questionToBeDeleted=entityManager.find(Questions.class,getToBeDeleted());
        if(questionDAO.delete(entityManager,questionToBeDeleted)){
            logger.info("Question deleted successfully");
        }
        else {
            logger.info("Question does not exist! Please enter a valid question");
        }
    }

    void setParameters(){
        setToBeDeleted(deleteQuestionUI.setParameter());
    }
}
