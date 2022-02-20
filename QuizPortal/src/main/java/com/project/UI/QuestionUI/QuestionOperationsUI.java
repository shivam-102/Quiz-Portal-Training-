package com.project.UI.QuestionUI;
import com.project.Service.Operation;
import com.project.Service.QuestionServices.OperationFactory;
import com.project.UI.QuizUI.QuizOperationsUI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Scanner;
public class QuestionOperationsUI {
    Scanner scanner=new Scanner(System.in);
    private static Logger logger= LogManager.getLogger(QuestionOperationsUI.class);

    public void operations(){
        while(true){
           listOfOperations();
           logger.info("Please enter you choice");
           int choice=scanner.nextInt();
           if(choice==0){
               break;
           }
           Operation operation= OperationFactory.getOperation(choice);
           operation.perform();
        }
    }
    void listOfOperations(){
        logger.info("Choose the operations you want to perform");
        logger.info("Press 1 to view the available questions");
        logger.info("Press 2 to add Question, Options, Difficulty(easy, difficulty or hard), correct answer");
        logger.info("Press 3 delete any question");
        logger.info("Press 4 to modify any part of question");
        logger.info("Press 0 to exit ");
    }
}
