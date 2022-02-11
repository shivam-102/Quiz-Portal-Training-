package com.project.Service;
import com.project.DAO.QuestionDAO;
import com.project.Exceptions.InvalidException;

import java.util.ArrayList;
import java.util.Scanner;

public class QuestionService {
    Scanner scanner=new Scanner(System.in);
    QuestionDAO questionDAO =new QuestionDAO();
    public void view(){
        ArrayList printList= questionDAO.printQuestions();
        for(int pointer=0;pointer< printList.size();pointer++){
            System.out.println( (pointer+1)+"."+printList.get(pointer).toString());
        }
    }
    public String addQuestion(String question,String[] options,String difficulty,String questionAnswer){
        if(questionDAO.addQuestion(question,options,difficulty,questionAnswer)){
            return "Added Successfully";
        }
        else
        {
            return "Cannot add it!";
        }
    }
    public String deleteQuestion(int index){
        if(questionDAO.deleteQuestion(index)){
            return "String deleted successfully";
        }
        return "Cannot delete that given question";
    }
    public String modify(int questionToBeModified,int choice){
        try {
            if (choice == 1) {
                System.out.println("Enter the modified Question");
                questionDAO.modifyQuestion(scanner.nextLine(), questionToBeModified);
                return "Question modification done";
            } else if (choice == 2) {
                System.out.println("Enter options");
                String[] newOptions = new String[4];
                for (int pointer = 0; pointer < 4; pointer++) {
                    newOptions[pointer] = scanner.nextLine();

                }
                questionDAO.modifyOptions(newOptions, questionToBeModified);
                return "Options modification done";
            } else if (choice == 3) {
                System.out.println("Enter the modified Difficulty");
                questionDAO.modifyDifficulty(scanner.nextLine(), questionToBeModified);
                return "Difficulty modification done";
            } else if (choice == 4) {
                System.out.println("Enter the modified Answer");
                questionDAO.modifyAnswer(scanner.nextLine(), questionToBeModified);
                return "Answer modification done";
            }
            else{
                throw new InvalidException("Enter valid option");

            }
        }catch(InvalidException message){
            System.out.println("Invalid option selected");
            System.out.println(message.getMessage());
        }
        return "Valid option";
    }

}
