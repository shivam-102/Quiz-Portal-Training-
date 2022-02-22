package com.project.dao;

import com.project.entity.Questions;

import java.util.Random;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;
public class QuizDAO {
    public static final Map<Integer, ArrayList<Questions>> quiz = new HashMap<>();
    private static QuizDAO quizDAOInstance=null;
    public static QuizDAO getInstance(){
        if(quizDAOInstance==null){
            return new QuizDAO();
        }
        return quizDAOInstance;
    }
    List<Object> selectedQuestions = new ArrayList<>();
    Random random=new Random();
    public int createQuiz(int[] arr) {
        ArrayList<String> questionsList = (ArrayList) QuestionDAO.questions;
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
        return quiz.containsKey(code);
    }


    public void addQuestion(int questionNumber,int code){
        quiz.get(code).add(QuestionDAO.questions.get(questionNumber));
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

    public List<Questions> view(int code){
        return quiz.get(code);
    }
}
