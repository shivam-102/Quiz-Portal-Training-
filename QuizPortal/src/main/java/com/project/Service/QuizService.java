package com.project.Service;

import com.project.DAO.QuizDAO;
import com.project.Exceptions.InvalidException;
import com.project.Exceptions.QuestionNotExist;
import com.project.UI.Welcome;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Scanner;

public class QuizService {
   static QuizDAO quizDAO =new QuizDAO();
    private Logger logger= LogManager.getLogger(QuizService.class);
    public static int createNewQuiz(int[] toAdd){
        int uniqueKey= quizDAO.createQuiz(toAdd);
        return uniqueKey;
    }

    public void checkWhetherExist(int code){
        Scanner scanner=new Scanner(System.in);
        if(quizDAO.checkIfThere(code)){

            while(true){
                optionsQuizOperations();
                try {
                    int choice = Integer.parseInt(scanner.nextLine());
                    if (choice == 1) {
                        logger.info("Press the question number you want to add");
                        int questionNumber = Integer.parseInt(scanner.nextLine());
                        quizDAO.addQuestion(questionNumber, code);
                        logger.info("Question added");
                    } else if (choice == 2) {
                        try {
                            logger.info("Enter the question number you want to delete");
                            if (quizDAO.deleteQuestion(Integer.parseInt(scanner.nextLine()) - 1, code)) {
                                logger.info("Question deleted");
                            } else {
                                throw new QuestionNotExist("Question does not exist in the quiz");
                            }
                        }catch(QuestionNotExist message){
                            logger.info("Enter a valid question to be deleted in the quiz");
                            logger.error(message.getMessage());
                        }
                    } else if (choice == 0) {
                        break;
                    } else {
                        throw new InvalidException("Enter a valid Option");
                    }
                }catch(InvalidException message){
                    logger.info("Invalid option selected");
                    logger.info(message.getMessage());
                }catch (Exception e){
                    logger.info(e.getMessage());
                }
            }
        }

    }
    void optionsQuizOperations(){
        System.out.println("Do you want to add or delete any question in this quiz?");
        System.out.println("Press 1 to add question");
        System.out.println("Press 2 to delete question");
        System.out.println("Press 0 to exit");
    }
    public void print(int code){
        ArrayList listToPrint= quizDAO.quiz.get(code);
        for(int pointer=0;pointer<listToPrint.size();pointer++)
        {
            System.out.println( (pointer+1)+"."+listToPrint.get(pointer).toString());
        }
    }
}
