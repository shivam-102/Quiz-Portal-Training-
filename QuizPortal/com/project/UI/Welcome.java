package com.project.UI;
import java.util.Scanner;
public class Welcome {
    Scanner scanner = new Scanner(System.in);
    Welcome() {
        welcome();
        do {
            System.out.println("Press 1 to go to go admin portal\nPress 2 to go to Player Portal\nPress 0 to exit");
            int choice=scanner.nextInt();
            if (choice == 1) {
                AdminUI.welcome(scanner);

            } else if (choice == 2) {
                    //todo
            } else if(choice==0) {
                break;
            }
            else{
                System.out.println("Enter a valid option");
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
