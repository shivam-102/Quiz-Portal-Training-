package com.project.UI;
import com.project.Exceptions.InvalidException;
import com.project.Service.QuestionService;
import com.project.Service.QuizService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Scanner;
public class QuizPortal {
    QuestionService questionOperations=new QuestionService();
    private Logger logger= LogManager.getLogger(QuizPortal.class);
    public void operations() {
        Scanner scanner=new Scanner(System.in);
        QuizService quizService=new QuizService();
        while(true){
            viewOperations();
            try {
                int quizOptionChoice = Integer.parseInt(scanner.nextLine());
                if (quizOptionChoice == 1) {
                    questionOperations.view();
                    logger.info("How many questions you want to add from the above displayed?");
                    int numberOfQuestions = Integer.parseInt(scanner.nextLine());
                    logger.info("Provide the question numbers you want to add into the quiz:");
                    int[] toAdd = new int[numberOfQuestions];
                    for (int pointer = 0; pointer < numberOfQuestions; pointer++) {
                        toAdd[pointer] = Integer.parseInt(scanner.nextLine()) - 1;
                    }
                    logger.info(QuizService.createNewQuiz(toAdd));
                } else if (quizOptionChoice == 2) {
                    logger.info("Enter the code of the quiz to modify...");
                    int code = Integer.parseInt(scanner.nextLine());
                    quizService.checkWhetherExist(code);
                } else if (quizOptionChoice == 3) {
                    logger.info("Enter the quiz code");
                    quizService.print(Integer.parseInt(scanner.nextLine()));
                }
                else if(quizOptionChoice==0){
                    break;
                }
                else {
                    throw new InvalidException("Please Enter a valid Option");
                }
            }catch(InvalidException message){
                logger.info("Invalid option selected");
                logger.info(message.getMessage());
            }
        }
    }
    void viewOperations() {
        logger.info("");
        logger.info("Press 1 to create New Quiz and add Questions");
        logger.info("Press 2 to modify the quiz by adding/deleting questions");
        logger.info("Press 3 to view quiz's");
        logger.info("Press 0 to exit the quiz");
        logger.info("Enter your choice");
    }
}
