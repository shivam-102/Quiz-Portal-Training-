package com.project.UI;

import java.util.Scanner;

public class Welcome {
    Scanner scanner = new Scanner(System.in);
   void QuizPortalStart() {

        System.out.println("---------------------------");
        System.out.println("Welcome to the Quiz Portal");
        System.out.println("---------------------------");
        System.out.println(" ");
        do {
            System.out.println("Press 1 to go to go admin portal or press 2 to go to player portal or press 0 to exit");
            if (scanner.nextInt() == 1) {
                AdminUI.welcome(scanner);

            } else if (scanner.nextInt() == 2) {
                    //todo
            } else if(scanner.nextInt()==0) {
                break;
            }
            else{
                System.out.println("Enter a valid option");
            }
        }while(true);
    }

}
