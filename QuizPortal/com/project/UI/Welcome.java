package com.project.UI;
import com.project.Exceptions.InvalidException;

import java.util.Scanner;
public class Welcome {
    Scanner scanner = new Scanner(System.in);
    Welcome() {
        welcome();
        do {
            try {
                System.out.println("Press 1 to go to go admin portal\nPress 2 to go to Player Portal\nPress 0 to exit");
                int choice = scanner.nextInt();
                if (choice == 1) {
                    AdminUI.welcome(scanner);

                } else if (choice == 2) {
                    //todo
                } else if (choice == 0) {
                    break;
                } else {
                    throw new InvalidException("Please enter a valid option");
                }
            }catch(InvalidException message){
                System.out.println("Invalid option selected");
                System.out.println(message.getMessage());

            }
        }while(true);
    }
    static void welcome(){
        System.out.println("---------------------------");
        System.out.println("Welcome to the Quiz Portal");
        System.out.println("---------------------------");
        System.out.println(" ");
    }
}
