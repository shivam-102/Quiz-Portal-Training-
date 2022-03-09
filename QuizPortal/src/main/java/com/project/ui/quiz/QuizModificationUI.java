package com.project.ui.quiz;

import com.project.exceptions.InvalidChoiceException;
import com.project.service.Operation;
import com.project.service.quizservice.QuizModificationService;
import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.Scanner;
@Component
public class QuizModificationUI implements Operation {
    @Getter
    @Setter
    private int code;
    static Logger logger= LogManager.getLogger(QuizModificationUI.class);
    Scanner scanner=new Scanner(System.in);
    QuizModificationService quizModificationService=new QuizModificationService();
    @Override
    public void perform() {
        logger.info("Enter the quiz code you want modify");
        setCode(Integer.parseInt(scanner.nextLine()));
        while(true){
            try {
                questionOperationList();
                int internalChoice = Integer.parseInt(scanner.nextLine());
                if (internalChoice == 0) {
                    break;
                } else if (internalChoice == 1) {
                    addQuestion();
                } else if (internalChoice == 2) {
                    deleteQuestion();
                }
                else{
                    throw new InvalidChoiceException("Please choose correct choice");
                }
            }catch(InvalidChoiceException message){
                logger.warn(message.getMessage());
            }
        }

    }
    void questionOperationList(){
        logger.info("Do you want to add or delete any question in this quiz?");
        logger.info("Press 1 to add question to the given quiz");
        logger.info("Press 2 to delete question to the given quiz");
        logger.info("Press 0 to exit");
    }
    void addQuestion(){
        logger.info("Press the question number you want to add");
        int questionNumber = Integer.parseInt(scanner.nextLine());
        if(quizModificationService.addQuestion(code,questionNumber)){
            logger.info("Modification done!");
        }
        else{
            logger.info("Modification not possible!");
        }

    }

    void deleteQuestion(){
        logger.info("Enter the question you want to delete");
        int questionNumber=Integer.parseInt(scanner.nextLine());
        if(quizModificationService.deleteQuestion(code,questionNumber)){
            logger.info("Modification done!");
        }
        else{
            logger.info("Modification not possible!");
        }
        //quizDAO.deleteQuestion(entityManager,code,questionNumber);
    }
}
