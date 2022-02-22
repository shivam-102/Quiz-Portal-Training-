package com.project.Service.QuizServices;
import com.project.DAO.QuizDAO;
import com.project.Service.Operation;
import com.project.UI.QuizUI.CreateQuizUI;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Scanner;

@Setter
public class CreateQuiz implements Operation {
    private Logger logger= LogManager.getLogger(CreateQuiz.class);
    QuizDAO quizDAO=QuizDAO.getInstance();
    Scanner scanner=new Scanner(System.in);
     int numberOfQuestions;
    CreateQuizUI createQuizUI=new CreateQuizUI();


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
        int[] toAdd=createQuizUI.questionsToBeAdded(numberOfQuestions);
        logger.info("Unique Key is:");
        logger.info(quizDAO.createQuiz(toAdd));
        return true;
    }
}
