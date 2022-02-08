package com.project.UI;

import java.util.Scanner;

public class AdminPortal{
    static Scanner scanner=new Scanner(System.in);
    public static void start(){
        System.out.println("--------------------------------");
        System.out.println("Welcome!!!!!");
        System.out.println("---------------------------------");
        System.out.println("Press 1 go to Question Bank\n Press2 to go to your Quiz Bank\nPress 3 to logout ");
        int adminChoice;
        do{
           adminChoice=scanner.nextInt();
           if(adminChoice==1){
               QuestionPortal.operations();
           }
           else if(adminChoice==2){
               QuizPortal.operations();

           }
           else
           {
               System.out.println("Enter valid operation");
           }
        }while(adminChoice!=0);
    }
}
