package com.project.UI;
import com.project.UI.QuestionUI.QuestionOperationsUI;
import com.project.UI.QuizUI.QuizOperationsUI;
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
                    continue;
                }
            } catch (NumberFormatException message) {
                logger.info(message);
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

