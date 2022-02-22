package com.project.ui.quizui;

import com.project.service.Operation;
import com.project.service.quizservices.QuizOperationFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class QuizOperationsUI {
    private Logger logger= LogManager.getLogger(QuizOperationsUI.class);
    Scanner scanner=new Scanner(System.in);
    public void operation(){
        while(true){
            listOfOperations();
            logger.info("Enter your choice");
            int choice=Integer.parseInt(scanner.nextLine());
            if(choice==0){
                break;
            }
            Operation operation= QuizOperationFactory.getQuestionOperation(choice);
            operation.perform();
        }
    }

    void listOfOperations(){
        logger.info("");
        logger.info("Press 1 view Available questions in Qestion Bank");
        logger.info("Press 2 to create New Quiz and add Questions");
        logger.info("Press 3 to modify the quiz by adding/deleting questions");
        logger.info("Press 4 to view quiz's");
        logger.info("Press 0 to exit the quiz");
        logger.info("Enter your choice");
    }
}
