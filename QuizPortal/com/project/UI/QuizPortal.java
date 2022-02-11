package com.project.UI;
import com.project.Exceptions.InvalidException;
import com.project.Service.QuestionService;
import com.project.Service.QuizService;
import java.util.Scanner;
public class QuizPortal {
    QuestionService questionOperations=new QuestionService();
    public void operations() {
        viewOperations();
        int quizOptionChoice = 0;
        Scanner scanner=new Scanner(System.in);
        QuizService quizService=new QuizService();

        do {
            try {
                quizOptionChoice = scanner.nextInt();
                if (quizOptionChoice == 1) {
                    questionOperations.view();
                    System.out.println("How many questions you want to add from the above displayed?");
                    int numberOfQuestions = scanner.nextInt();
                    System.out.println("Provide the question numbers you want to add into the quiz:");
                    int[] toAdd = new int[numberOfQuestions];
                    for (int pointer = 0; pointer < numberOfQuestions; pointer++) {
                        toAdd[pointer] = scanner.nextInt() - 1;
                    }
                    System.out.println(QuizService.createNewQuiz(toAdd));
                } else if (quizOptionChoice == 2) {
                    System.out.println("Enter the code of the quiz to modify...");
                    int code = scanner.nextInt();
                    quizService.checkWhetherExist(code);
                } else if (quizOptionChoice == 3) {
                    System.out.println("Enter the quiz code");
                    quizService.print(scanner.nextInt());
                } else {
                    throw new InvalidException("Please Enter a valid Option");
                }
            }catch(InvalidException message){
                System.out.println("Invalid option selected");
                System.out.println(message.getMessage());
            }
        } while (quizOptionChoice != 0);
    }

    void viewOperations() {
        System.out.println("");
        System.out.println("Press 1 to create New Quiz and add Questions");
        System.out.println("Press 2 to modify the quiz by adding/deleting questions");
        System.out.println("Press 3 to view quiz's");
        System.out.println("Press 0 to exit the quiz");
        System.out.println("Enter your choice");
    }
}
