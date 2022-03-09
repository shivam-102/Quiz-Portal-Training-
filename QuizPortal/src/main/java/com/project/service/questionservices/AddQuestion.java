package com.project.service.questionservices;
import com.project.dao.QuestionDAO;
import com.project.entity.Options;
import com.project.entity.Questions;
import com.project.service.Operation;
import com.project.ui.questionui.AddQuestionUI;
import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;


public class AddQuestion implements Operation {
    AddQuestionUI addQuestionUI = new AddQuestionUI();
    private static Logger logger = LogManager.getLogger(AddQuestion.class);
    @Setter
    @Getter
    private String question;
    @Setter
    @Getter
    private String difficulty;
    @Setter
    @Getter
    private List<Options> options;
    Questions questions=new Questions();
    QuestionDAO questionDAO = QuestionDAO.getInstance();
    EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("Quiz-Portal");
    EntityManager entityManager=entityManagerFactory.createEntityManager();
    public AddQuestion(){

    }

    public AddQuestion(QuestionDAO questionDAO) {
        this.questionDAO=questionDAO;
    }

    @Override
    public void perform() {
        getParameters();
        questions.setQuestion(getQuestion());
        questions.setDifficulty(getDifficulty());
        questions.setOption(getOptions());
        if(questionDAO.insert(entityManager,questions)){
            logger.info("Question inserted to our database");
        }
        else{
            logger.info("Can't insert the question");
        }
    }

    void getParameters(){
        setQuestion(addQuestionUI.question());
        setDifficulty(addQuestionUI.difficulty());
        setOptions(addQuestionUI.options());
    }

}