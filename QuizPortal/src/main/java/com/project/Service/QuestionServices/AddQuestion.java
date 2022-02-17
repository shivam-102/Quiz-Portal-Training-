package com.project.Service.QuestionServices;
import com.project.DAO.QuestionDAO;
import com.project.Service.Operation;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

@Setter
public class AddQuestion implements Operation {
    private static Logger logger= LogManager.getLogger(AddQuestion.class);
    Scanner scanner=new Scanner(System.in);
    private String question;
    private String[] options;
    private String difficulty;
    private String questionAnswer;
    QuestionDAO questionDAO=QuestionDAO.getInstance();
    @Override
    public void perform() {
        getParameters();
        if(questionDAO.addQuestion(question, options, difficulty, questionAnswer)){
            logger.info("Question has been added");
        }
        else{
            logger.info("Failed to add question");
        }
    }
    void getParameters(){
        logger.info("Please enter the question");
        setQuestion(scanner.nextLine());
        scanner.nextLine();
        logger.info("Enter the options you want to keep");
        String[] options =new String[4];
        for(int input=0;input< options.length;input++){
            logger.info("Enter option"+(input+1));
            options[input]=scanner.nextLine();
        }
        setOptions(options);
        scanner.nextLine();
        logger.info("Enter the difficulty level");
        setDifficulty(scanner.nextLine());
        logger.info("Enter the correct answer");
        setQuestionAnswer(scanner.nextLine());
    }
}
