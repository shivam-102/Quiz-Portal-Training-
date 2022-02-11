package com.project.Service;

import com.project.DAO.QuizDAO;
import com.project.Exceptions.InvalidException;

import java.util.ArrayList;
import java.util.Scanner;

public class QuizService {
   static QuizDAO quizDAO =new QuizDAO();
    public static int createNewQuiz(int[] toAdd){
        int uniqueKey= quizDAO.createQuiz(toAdd);
        return uniqueKey;
    }

    public void checkWhetherExist(int code){
        Scanner scanner=new Scanner(System.in);
        if(quizDAO.checkIfThere(code)){
            optionsQuizOperations();
            int choice=0;
            while(true){
                try {
                    choice = scanner.nextInt();
                    if (choice == 1) {
                        System.out.println("Press the question number you want to add");
                        int questionNumber = scanner.nextInt();
                        quizDAO.addQuestion(questionNumber, code);
                        System.out.println("Question added");
                    } else if (choice == 2) {
                        System.out.println("Enter the question number you want to delete");
                        quizDAO.deleteQuestion(scanner.nextInt(), code);
                        System.out.println("Question deleted");
                    } else if (choice == 0) {
                        break;
                    } else {
                        throw new InvalidException("Enter a valid Option");
                    }
                }catch(InvalidException message){
                    System.out.println("Invalid option selected");
                    System.out.println(message.getMessage());
                }
            }
        }

    }
    void optionsQuizOperations(){
        System.out.println("Do you want to add or delete any question in this quiz?");
        System.out.println("Press 1 to add question");
        System.out.println("Press 2 to delete question");
        System.out.println("Press 0 to exit");
    }


       public void print(int code){
        ArrayList listToPrint= quizDAO.quiz.get(code);
        for(int pointer=0;pointer<listToPrint.size();pointer++)
        {
            System.out.println( (pointer+1)+"."+listToPrint.get(pointer).toString());
        }
    }
}
