package com.project.dao;
import com.project.entity.Questions;
import java.util.ArrayList;
import java.util.List;
public class QuestionDAO {
    private static QuestionDAO questionDAOInstance=null;
    public static QuestionDAO getInstance(){
        if(questionDAOInstance==null){
            return new QuestionDAO();
        }
        return questionDAOInstance;
    }
    public static final List<Questions> questions = new ArrayList<>();
    static {
            questions.add(new Questions("Number of primitive data types in Java are?", new String[]{"6", "7", "8", "9"}, "Easy", "8"));
            questions.add(new Questions("What is the size of float and double in java?", new String[]{"32 and 64", "32 and 32", "64 and 64", "64 and 32"}, "easy", "32 and 64"));
            questions.add(new Questions("Automatic type conversion is possible in which of the possible cases?", new String[]{"Byte to int", "Int to Long", "Long to int", "Short to int"}, "medium", "Int to Long"));
            questions.add(new Questions("Select the valid statement", new String[]{"char[] ch=new char(5)", "char[] ch=new char[5]", "char[] ch=new char()", "char[] ch=new char[]"}, "hard", "char[] ch=new char[5]"));
            questions.add(new Questions("Select the valid statement to declare and initialize an array.", new String[]{"int[] A={}", "int[] A={1,2,3}", "int[] A=(1,2,3)", "int[][] A={1,2,3}"}, "hard", "int[] A={1,2,3}"));
    }
     QuestionDAO(){}

    public List<Questions> printQuestions() {
        return (ArrayList<Questions>) questions;
    }

    public boolean addQuestion(String yourQuestion, String[] yourOptions, String setDifficulty, String correctAnswer) {
        questions.add(new Questions(yourQuestion, yourOptions, setDifficulty, correctAnswer));
        return true;
    }

    public boolean deleteQuestion(int indexToDelete) {
        if(indexToDelete>questions.size()){
            return false;
        }
        else{
            questions.remove(indexToDelete);
            return true;
        }

    }
    public void modifyQuestion(String question,int number) {
        questions.get(number - 1).setQuestion(question);
    }
    public void modifyOptions(String[] options,int number){
        questions.get(number-1).setOptions(options);
    }

    public void modifyDifficulty(String difficulty,int number){
        questions.get(number-1).setDifficulty(difficulty);
    }

    public void modifyAnswer(String answer,int number){
        questions.get(number-1).setAnswer(answer);
    }

}
