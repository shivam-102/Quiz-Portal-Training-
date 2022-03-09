package com.project.service.questionservices;
import com.project.entity.Questions;
import com.project.service.Operation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
public class ViewQuestionAvailable implements Operation {
    private Logger logger= LogManager.getLogger(ViewQuestionAvailable.class);
    EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("Quiz-Portal");
    EntityManager entityManager=entityManagerFactory.createEntityManager();
    @Override
    public void perform() {
        display();
    }
    void display(){
        List<Questions> questionsToDisplay = entityManager.createQuery("select new com.project.entity.Questions(q.id,q.question,q.difficulty) from Questions q", Questions.class)
                .getResultList();
        questionsToDisplay.forEach(question -> logger.info(question));
    }
}
