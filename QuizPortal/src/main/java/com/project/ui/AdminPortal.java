package com.project.ui;
import com.project.exceptions.InvalidChoiceException;
import com.project.ui.question.QuestionOperationsUI;
import com.project.ui.quiz.QuizOperationsUI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Scanner;
public class AdminPortal {
    private Logger logger = LogManager.getLogger(AdminPortal.class);
    static Scanner scanner = new Scanner(System.in);
    QuestionOperationsUI questionOperationsUI=new QuestionOperationsUI();
    QuizOperationsUI quizOperationsUI=new QuizOperationsUI();
    public void start() {
        while (true) {
            optionDisplay();
            try {
                int adminChoice = Integer.parseInt(scanner.nextLine());
                if (adminChoice == 1) {
                    questionOperationsUI.operations();
                } else if (adminChoice == 2) {
                    quizOperationsUI.operation();
                } else if (adminChoice == 0) {
                    break;
                } else {
                    throw new InvalidChoiceException("Enter a valid choice");
                }
            } catch (NumberFormatException message) {
                logger.warn(message);
            } catch(InvalidChoiceException message){
                logger.warn(message);
            }
        }
    }

        public void optionDisplay() {
            logger.info("--------------------------------");
            logger.info("Welcome!!!!!");
            logger.info("---------------------------------");
            logger.info("Press 1 go to Question Bank\n Press2 to go to your Quiz Bank\nPress 0 to logout ");
        }

}

