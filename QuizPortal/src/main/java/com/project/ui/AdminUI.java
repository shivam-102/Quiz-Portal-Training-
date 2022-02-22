package com.project.ui;
import com.project.entity.User;
import com.project.service.UserValidation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Scanner;
public class AdminUI {
    private AdminUI(){

    }
    private static Logger logger= LogManager.getLogger(AdminUI.class);
    static void welcome(Scanner scanner){
        logger.info("Welcome to Admin Portal");
        AdminPortal adminPortal=new AdminPortal();
        User user=new User();
        UserValidation userValidation=new UserValidation();
        while(true) {
            logger.info("Press 1 to login Press 2 to sign-up Press 3 to exit");
            logger.info("Please enter your choice");
            int choice=Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                logger.info("Enter the username");
                user.setUserName(scanner.next());
                scanner.nextLine();
                logger.info("Enter password");
                user.setPassword(scanner.next());
                scanner.nextLine();
                if(userValidation.verify(user.getUserName(),user.getPassword()))
                {
                    adminPortal.start();
                }
                else{
                    logger.info("Bad username or password. Please enter a valid one. Or Press 2 to sign-up");
                }
            }
            else if(choice==2){
                logger.info("Enter the username you want to register:");
                user.setUserName(scanner.next());
                scanner.nextLine();
                logger.info("Enter the password to register:");
                user.setPassword(scanner.next());
                scanner.nextLine();
                if(userValidation.checkIfUserNameExists(user.getUserName(),user.getPassword())){
                    logger.info("User Registered as admin");
                }
                else{
                    logger.info("Please re-enter the username");
                }

            }
            else {
                break;
            }
        }
    }
}
