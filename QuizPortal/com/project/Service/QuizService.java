package com.project.Service;

import java.util.ArrayList;
import java.util.Scanner;

public class QuizService {
   static QuizLibrary quizLibrary=new QuizLibrary();
    private static Scanner scanner;
    public static int createNewQuiz(int[] toAdd){
        int uniqueKey=quizLibrary.createQuiz(toAdd);
        return uniqueKey;
    }
    public static boolean checkWhetherExist(int code){
        if(quizLibrary.checkIfThere(code)){
            return true;
        }
        return false;

    }
    public static void modify(int code){
        int choice=0;
        do{
            System.out.println("Press 1 to add questions in the quiz\n Press 2 to delete questions in the quiz\nPress 3 to exit");
            choice=scanner.nextInt();
            if(choice==1){
                QuestionOperations.view();
                System.out.println("Enter the question number you want to insert");
                int questionToInsert=scanner.nextInt();
                quizLibrary.addQuestion(questionToInsert,code);
                System.out.println("Done!");
            }
            else if(choice==2){
                System.out.println("Question to delete in the quiz");
                int numberToDelete=scanner.nextInt();
                System.out.println(quizLibrary.deleteQuestion(code,numberToDelete));
                quizLibrary.view(code);
            }
            else {
                System.out.println("Enter a valid option");
            }
        }while(choice!=0);
    }
    void print(int code){
        ArrayList listToPrint=quizLibrary.view(code);
        for(int pointer=0;pointer<listToPrint.size();pointer++)
        {
            System.out.println( (pointer+1)+"."+listToPrint.get(pointer).toString());
        }
    }
}
