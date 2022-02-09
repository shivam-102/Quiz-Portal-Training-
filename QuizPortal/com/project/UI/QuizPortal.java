package com.project.UI;

import com.project.Service.QuestionOperations;
import com.project.Service.QuizService;

import static com.project.UI.AdminPortal.scanner;

public class QuizPortal {
    public static void operations() {
        System.out.println("");
        System.out.println("Press 1 to create New Quiz and add Questions");
        System.out.println("Press 2 to modify the quiz by adding/deleting questions");
        System.out.println("Press 0 to exit the quiz");
        System.out.println("Enter your choice");
        QuizService quizService=new QuizService();
        int quizChoice=0;
        do {
            int quizOptionChoice = scanner.nextInt();
            if (quizOptionChoice == 1) {
                QuestionOperations.view();
                System.out.println("How many questions you want to add from the above displayed?");
                int numberOfQuestions=scanner.nextInt();
                System.out.println("Provide the question numbers you want to add into the quiz:");
                int[] toAdd = new int[numberOfQuestions];
                for (int pointer = 0; pointer < numberOfQuestions; pointer++) {
                    toAdd[pointer] = scanner.nextInt()-1;
                }
                System.out.println(QuizService.createNewQuiz(toAdd));
            }
            else if(quizOptionChoice==2){
                System.out.println("Enter the code of the quiz to modify...");
                int code= scanner.nextInt();
                if(QuizService.checkWhetherExist(code)){
                    QuizService.modify(code);

                }
                else{
                    System.out.println("Code does not exist");
                }
            }

        }while(quizChoice!=0);
    }
}
