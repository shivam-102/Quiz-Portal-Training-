package com.project.UI;
import com.project.Entity.User;
import com.project.Service.UserValidation;
import java.util.Scanner;

public class AdminUI {
    static void welcome(Scanner scanner){
        System.out.println("Welcome to Admin Portal");
        User user=new User();
        UserValidation userValidation=new UserValidation();
        int choice=0;
        while(choice!=3) {
            System.out.println("Press 1 to login Press 2 to sign-up Press 3 to exit");
            System.out.println("Please enter your choice");
            choice=scanner.nextInt();
            if (choice == 1) {
                System.out.println("Enter the username");
                user.setUserName(scanner.next());
                System.out.println("Enter password");
                user.setPassword(scanner.next());
                userValidation.verify(user.getUserName(),user.getPassword());
            }
            else if(choice==2){
                System.out.println("Enter the username you want to register:");
                user.setUserName(scanner.next());
                System.out.println("Enter the password to register:");
                user.setPassword(scanner.next());
                if(userValidation.checkIfUserNameExists(user.getUserName(),user.getPassword())){
                    System.out.println("User Registered as admin");
                }
                else{
                    System.out.println("Please re-enter the username");
                }

            }
            else {
                break;
            }
        }
    }
}
