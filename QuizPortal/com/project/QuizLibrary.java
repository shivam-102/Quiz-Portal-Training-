package com.project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuizLibrary {
    Map<Integer,ArrayList> quiz=new HashMap<>();
    List<Object> selectedQuestions=new ArrayList<Object>();
    QuestionBank questionBankAccess=new QuestionBank();
    String createQuiz(int arr[]){

        ArrayList questionsList= (ArrayList) questionBankAccess.questions;
        questionsList.toString();
        for(int pointer=0;pointer<arr.length;pointer++){
            selectedQuestions.add(questionsList.get(arr[pointer]));
        }
        int uniqueKey = (int)(Math.random()*(1-1000+1)+1);
        quiz.put(uniqueKey,questionsList);
        return "created a quiz";
    }

    ArrayList view(){
        return (ArrayList) questionBankAccess.questions;
    }

}
