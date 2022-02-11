package com.project.UI;
import com.project.Exceptions.InvalidException;
import com.project.Service.QuestionService;
import static com.project.UI.AdminPortal.scanner;
public class QuestionPortal {
    QuestionService questionOperations=new QuestionService();
    void operations(){
        int operationChoice = 0;
        do{
            try {
                operationsView();
                operationChoice = scanner.nextInt();
                if (operationChoice == 1) {
                    questionOperations.view();
                } else if (operationChoice == 2) {
                    viewAddOperation();
                } else if (operationChoice == 3) {
                    System.out.println("Enter the question number you want to delete from the question database");
                    int toBeDeletedQuestion = scanner.nextInt();
                    questionOperations.deleteQuestion(toBeDeletedQuestion - 1);

                } else if (operationChoice == 4) {
                    viewModifyOperation();
                } else {
                    throw new InvalidException("Please enter a valid option");
                }
            }catch(InvalidException message){
                System.out.println("Invalid option selected");
                System.out.println(message.getMessage());
            }
        }while(operationChoice!=0);
    }

    void operationsView(){
        System.out.println("Choose the operations you want to perform");
        System.out.println("Press 1 to view the available questions");
        System.out.println("Press 2 to add Question, Options, Difficulty(easy, difficulty or hard), correct answer");
        System.out.println("Press 3 delete any question");
        System.out.println("Press 4 to modify any part of question");
        System.out.println("Press 0 to exit ");
    }


    void viewAddOperation(){
        System.out.println("Press Enter");
        scanner.nextLine();
        System.out.println("Please enter the question");
        String question=scanner.nextLine();
        System.out.println("Enter the options you want to keep");
        String[] options =new String[4];
        for(int input=0;input< options.length;input++){
            System.out.println("Enter option"+(input+1));
            options[input]=scanner.nextLine();
        }
        scanner.nextLine();
        System.out.println("Enter the difficulty level");
        String difficulty=scanner.nextLine();
        System.out.println("Enter the correct answer");
        String answer=scanner.nextLine();
        System.out.println(questionOperations.addQuestion(question,options,difficulty,answer));
    }

    void viewModifyOperation(){
        System.out.println("Enter the question number which you want to modify?");
        int questionToBeModified=scanner.nextInt();
        System.out.println("What do you want to modify");
        System.out.println("1.Question\n2.Options\n3.difficulty Level\n4.Answer");
        int modifyChoice=scanner.nextInt();
        System.out.println(questionOperations.modify(questionToBeModified,modifyChoice));
    }

}
