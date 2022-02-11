package com.project.Service;

import com.project.DAO.QuizDAO;

import java.util.ArrayList;
import java.util.Scanner;

public class QuizService {
   static QuizDAO quizDAO =new QuizDAO();
    private static Scanner scanner;
    public static int createNewQuiz(int[] toAdd){
        int uniqueKey= quizDAO.createQuiz(toAdd);
        return uniqueKey;
    }

    public void checkWhetherExist(int code){
        Scanner scanner=new Scanner(System.in);
        if(quizDAO.checkIfThere(code)){
            System.out.println("Do you want to add or delete any question in this quiz?");
            System.out.println("Press 1 to add question");
            System.out.println("Press 2 to delete question");
            System.out.println("Press 0 to exit");
            int choice=0;
            while(true){
                choice=scanner.nextInt();
                if(choice==1){
                    System.out.println("Press the question number you want to add");
                    int questionNumber=scanner.nextInt();
                    quizDAO.addQuestion(questionNumber,code);
                    System.out.println("Question added");
                }
                else if(choice==2){
                    System.out.println("Enter the question number you want to delete");
                    quizDAO.deleteQuestion(scanner.nextInt(), code);
                    System.out.println("Question deleted");
                }
                else if(choice==0){
                    break;
                }
                else{
                    System.out.println("Enter valid option");
                }
            }
        }

    }

    public void modify(int code){
        QuestionOperations questionOperations=new QuestionOperations();
        int choice=0;
        do{
            System.out.println("Press 1 to add questions in the quiz\n Press 2 to delete questions in the quiz\nPress 3 to exit");
            choice=scanner.nextInt();
            if(choice==1){
                questionOperations.view();
                System.out.println("Enter the question number you want to insert");
                int questionToInsert=scanner.nextInt();
                quizDAO.addQuestion(questionToInsert,code);
                System.out.println("Done!");
            }
            else if(choice==2){
                System.out.println("Question to delete in the quiz");
                int numberToDelete=scanner.nextInt();
                System.out.println(quizDAO.deleteQuestion(code,numberToDelete));
                quizDAO.view(code);
            }
            else {
                System.out.println("Enter a valid option");
            }
        }while(choice!=0);
    }


    public void print(int code){
        ArrayList listToPrint= quizDAO.quiz.get(code);
        for(int pointer=0;pointer<listToPrint.size();pointer++)
        {
            System.out.println( (pointer+1)+"."+listToPrint.get(pointer).toString());
        }
    }
}
