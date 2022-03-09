package com.project.service.quizservices;
import com.project.Configurationn;
import com.project.service.CustomObjectFactory;
import com.project.dao.QuizDAO;
import com.project.entity.Questions;
import com.project.service.Operation;
import com.project.ui.quizui.ViewQuizUI;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Scanner;
@Setter
public class ViewQuiz implements Operation {
    int code;
    private Logger logger= LogManager.getLogger(ViewQuiz.class);
    ApplicationContext applicationContext= new AnnotationConfigApplicationContext(Configurationn.class);
    CustomObjectFactory customObjectFactory=applicationContext.getBean(CustomObjectFactory.class);
    QuizDAO quizDAO=QuizDAO.getInstance();
    Scanner scanner=new Scanner(System.in);
    ViewQuizUI viewQuizUI=new ViewQuizUI();
    EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("Quiz-Portal");
    EntityManager entityManager=entityManagerFactory.createEntityManager();
    @Override
    public void perform() {
        getCode();
        display(code);
    }
    public void display(int code){
        String queryString="select quiz.questionsList from Quiz quiz where quiz.code=:code";
        List<Questions> questionsInThisCode=entityManager.createQuery(queryString).setParameter("code",code).getResultList();
        questionsInThisCode.forEach(question ->
            logger.info(question)
        );
    }
    void getCode(){
        logger.info("Provide the Quiz code");
        setCode(viewQuizUI.getQuizCode());
    }
}
