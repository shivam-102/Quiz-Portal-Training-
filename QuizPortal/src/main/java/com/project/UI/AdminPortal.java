package com.project.UI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;
public class AdminPortal {
    private Logger logger = LogManager.getLogger(AdminPortal.class);
    static Scanner scanner = new Scanner(System.in);
    QuestionPortal questionPortal = new QuestionPortal();
    QuizPortal quizPortal = new QuizPortal();

    public void start() {

        while (true) {
            optionDisplay();
            try {
                int adminChoice = Integer.parseInt(scanner.nextLine());
                if (adminChoice == 1) {
                    questionPortal.operations();
                } else if (adminChoice == 2) {
                    quizPortal.operations();
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

