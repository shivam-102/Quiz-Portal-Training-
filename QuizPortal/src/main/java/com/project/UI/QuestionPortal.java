package com.project.UI;
import com.project.Service.QuestionService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.project.UI.AdminPortal.scanner;
public class QuestionPortal {
    QuestionService questionOperations=new QuestionService();
   //ModifyQuestion modifyQuestion=new ModifyQuestion();
   private Logger logger= LogManager.getLogger(QuestionPortal.class);
    void operations(){
        do{
            try {
                operationsView();
                 int operationChoice = Integer.parseInt(scanner.nextLine());
                if (operationChoice == 1) {
                    questionOperations.view();
                } else if (operationChoice == 2) {
                    viewAddOperation();
                } else if (operationChoice == 3) {
                    logger.info("Enter the question number you want to delete from the question database");
                    int toBeDeletedQuestion = Integer.parseInt(scanner.nextLine());
                    questionOperations.deleteQuestion(toBeDeletedQuestion - 1);

                } else if (operationChoice == 4) {
                    viewModifyOperation();
                }
               else if(operationChoice==0){
                   break;
                }
                else {
                    continue;
                }
            }catch(NumberFormatException message){
                logger.info(message);
            }
        }while(true);
    }

    void operationsView(){
        logger.info("Choose the operations you want to perform");
        logger.info("Press 1 to view the available questions");
        logger.info("Press 2 to add Question, Options, Difficulty(easy, difficulty or hard), correct answer");
        logger.info("Press 3 delete any question");
        logger.info("Press 4 to modify any part of question");
        logger.info("Press 0 to exit ");
    }
    void viewAddOperation(){
        logger.info("Press Enter");
        scanner.nextLine();
        logger.info("Please enter the question");
        String question=scanner.nextLine();
        logger.info("Enter the options you want to keep");
        String[] options =new String[4];
        for(int input=0;input< options.length;input++){
            logger.info("Enter option"+(input+1));
            options[input]=scanner.nextLine();
        }
        scanner.nextLine();
        logger.info("Enter the difficulty level");
        String difficulty=scanner.nextLine();
        logger.info("Enter the correct answer");
        String answer=scanner.nextLine();
        logger.info(questionOperations.addQuestion(question,options,difficulty,answer));
    }
    void viewModifyOperation(){
        logger.info("Enter the question number which you want to modify?");
        int questionToBeModified=Integer.parseInt(scanner.nextLine());
        logger.info("What do you want to modify");
        logger.info("1.Question\n2.Options\n3.difficulty Level\n4.Answer");
        int modifyChoice=Integer.parseInt(scanner.nextLine());
        logger.info(questionOperations.modify(questionToBeModified,modifyChoice));
    }

}
