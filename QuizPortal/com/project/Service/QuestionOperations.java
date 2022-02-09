package com.project.Service;
import java.util.ArrayList;
public class QuestionOperations {
    static QuestionBank questionBank=new QuestionBank();
    public static void view(){
        ArrayList printList= questionBank.printQuestions();
        for(int pointer=0;pointer< printList.size();pointer++){
            System.out.println( (pointer+1)+"."+printList.get(pointer).toString());
        }
    }
    public static String addQuestion(String question,String[] options,String difficulty,String questionAnswer){
        if(questionBank.addQuestion(question,options,difficulty,questionAnswer)){
            return "Added Successfully";
        }
        else
        {
            return "Cannot add it!";
        }
    }
    public static String deleteQuestion(int index){
        if(questionBank.deleteQuestion(index)){
            return "String deleted successfully";
        }
        return "Cannot delete that given question";
    }

}
