package com.project.Service.QuizServices;
import com.project.DAO.QuizDAO;
import com.project.Service.Operation;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Scanner;

@Setter
public class CreateQuiz implements Operation {
    private Logger logger= LogManager.getLogger(CreateQuiz.class);
    QuizDAO quizDAO=QuizDAO.getInstance();
    Scanner scanner=new Scanner(System.in);
    private int numberOfQuestions;

    @Override
    public void perform() {
        numberOfQuestions();
        logger.info("Provide the question numbers you want to add into the quiz:");
        addQuestions();

    }
    void numberOfQuestions(){
        logger.info("How many questions you want to keep in the quiz?");
        setNumberOfQuestions(Integer.parseInt(scanner.nextLine()));
    }
    void addQuestions(){
        logger.info("Provide the question numbers you want to add into the quiz:");
        int[] toAdd = new int[numberOfQuestions];
        for (int pointer = 0; pointer < numberOfQuestions; pointer++) {
            toAdd[pointer] = Integer.parseInt(scanner.nextLine()) - 1;
        }
        logger.info("Unique Key is:"+quizDAO.createQuiz(toAdd));
    }
}
