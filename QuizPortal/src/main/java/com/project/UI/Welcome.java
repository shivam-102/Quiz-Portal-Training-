package com.project.UI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;
public class Welcome {
    Scanner scanner = new Scanner(System.in);
    private Logger logger= LogManager.getLogger(Welcome.class);
    Welcome() {
        firstPage();
        do {
            try {
                logger.info("Press 1 to go to go admin portal\nPress 2 to go to Player Portal\nPress 0 to exit");
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice == 1) {
                    AdminUI.welcome(scanner);

                } else if (choice == 2) {
                    //todo
                } else if (choice == 0) {
                    break;
                } else {
                }
            }catch(NumberFormatException message){
                logger.info(message);
            }

        } while (true);
    }

    void firstPage(){
        logger.info("---------------------------");
        logger.info("Welcome to the Quiz Portal");
        logger.info("---------------------------");
        logger.info(" ");
    }
}
