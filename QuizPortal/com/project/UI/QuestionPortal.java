package com.project.UI;
import com.project.Service.QuestionOperations;
import static com.project.UI.AdminPortal.scanner;
public class QuestionPortal {
    static void operations(){

        System.out.println("Choose the operations you want to perform");
        System.out.println("Press 1 to view the available questions");
        System.out.println("Press 2 to add Question, Options, Difficulty(easy, difficulty or hard), correct answer");
        System.out.println("Press 3 delete any question");
        System.out.println("Press 0 to exit ");
        int operationChoice = 0;
        do{
            operationChoice=scanner.nextInt();
            if(operationChoice==1)
            {
                QuestionOperations.view();

            }
            else if(operationChoice==2){
                System.out.println("Please enter the question");
                String question=scanner.next();
                System.out.println("Enter the options you want to keep");
                String options[]=new String[4];
                for(int input=0;input< options.length;input++){
                    System.out.println("Enter option"+(input+1));
                    options[input]=scanner.next();
                }
                System.out.println("Enter the difficulty level");
                String difficulty=scanner.nextLine();
                System.out.println("Enter the correct answer");
                String answer=scanner.nextLine();
                System.out.println(QuestionOperations.addQuestion(question,options,difficulty,answer));

            }

            else if(operationChoice==3){
                System.out.println("Enter the question number you want to delete from the question database");
                int toBeDeletedQuestion=scanner.nextInt();
                QuestionOperations.deleteQuestion(toBeDeletedQuestion-1);

            }
            else {
                System.out.println("Please enter a valid option");
            }
        }while(operationChoice!=0);
    }
}
