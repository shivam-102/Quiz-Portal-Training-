package com.project.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.project.Service.QuestionOperations.questionBank;

public class QuizLibrary {
    Map<Integer, ArrayList> quiz = new HashMap<>();
    List<Object> selectedQuestions = new ArrayList<Object>();
    QuestionBank questionBankAccess = new QuestionBank();

    public int createQuiz(int arr[]) {
        int min = 90;
        int max = 1000;
        ArrayList questionsList = (ArrayList) questionBankAccess.questions;
        for (int pointer = 0; pointer < arr.length; pointer++) {
            selectedQuestions.add(questionsList.get(arr[pointer]));
        }
        int uniqueKey = (int) (Math.random() * (min - max + 1) + min);
        do {
            if (quiz.containsKey(uniqueKey)) {
                uniqueKey = (int) (Math.random() * (min - max + 1) + min);
            } else {
                break;
            }
        } while (true);
        quiz.put(uniqueKey, questionsList);
        return uniqueKey;
    }

    boolean checkIfThere(int code) {
        if (quiz.containsKey(code)) {
            return true;
        }
        return false;
    }


    public void addQuestion(int questionNumber,int code){
        quiz.get(code).add(questionBankAccess.questions.get(questionNumber));
    }
    public String deleteQuestion(int deleteQuestionNumber,int code){
        quiz.get(code).remove(deleteQuestionNumber);
        return "Deleted";
    }

    ArrayList view(){
        return (ArrayList) questionBank.questions;
    }
}
