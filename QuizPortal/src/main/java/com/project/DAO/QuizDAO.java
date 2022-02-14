package com.project.DAO;

import java.util.Random;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;
public class QuizDAO {
    public Map<Integer, ArrayList> quiz = new HashMap<>();
    List<Object> selectedQuestions = new ArrayList<Object>();
    QuestionDAO questionDAOAccess = new QuestionDAO();
    Random random=new Random();
    public int createQuiz(int arr[]) {
        ArrayList questionsList = (ArrayList) questionDAOAccess.questions;
        for (int pointer = 0; pointer < arr.length; pointer++) {
            selectedQuestions.add(questionsList.get(arr[pointer]));
        }
        int uniqueKey = random.nextInt(1000);
        do {
            if (quiz.containsKey(uniqueKey)) {
                uniqueKey = random.nextInt(1000);
            } else {
                break;
            }
        } while (true);
        quiz.put(uniqueKey, (ArrayList) selectedQuestions);
        return uniqueKey;
    }

    public boolean checkIfThere(int code) {
        if (quiz.containsKey(code)) {
            return true;
        }
        return false;
    }


    public void addQuestion(int questionNumber,int code){
        quiz.get(code).add(questionDAOAccess.questions.get(questionNumber));
    }
    public boolean deleteQuestion(int deleteQuestionNumber,int code){
        if(deleteQuestionNumber>quiz.size()) {
            return false;
        }
        else{
            quiz.get(code).remove(deleteQuestionNumber);
            return true;
        }

    }

    public ArrayList view(int code){
        return (ArrayList) quiz.get(code);
    }
}
