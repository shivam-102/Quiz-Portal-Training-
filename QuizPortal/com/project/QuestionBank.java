package com.project;
import java.util.ArrayList;
import java.util.List;
public class QuestionBank {
List<Questions> questions=new ArrayList<>();
QuestionBank(){
    questions.add(new Questions("Number of primitive data types in Java are?",new String[]{"6","7","8","9"},"Easy","8"));
    questions.add(new Questions("What is the size of float and double in java?",new String[]{"32 and 64","32 and 32","64 and 64","64 and 32"},"easy","32 and 64"));
    questions.add(new Questions("Automatic type conversion is possible in which of the possible cases?",new String[]{"Byte to int","Int to Long","Long to int","Short to int"},"medium","Int to Long"));
    questions.add(new Questions("Select the valid statement",new String[]{"char[] ch=new char(5)","char[] ch=new char[5]","char[] ch=new char()","char[] ch=new char[]"},"hard","char[] ch=new char[5]"));
    questions.add(new Questions("Select the valid statement to declare and initialize an array.",new String[]{"int[] A={}","int[] A={1,2,3}","int[] A=(1,2,3)","int[][] A={1,2,3}"},"hard","int[] A={1,2,3}"));
}
ArrayList printQuestions(){
    return (ArrayList) questions;
}
String addQuestion(String yourQuestion,String yourOptions[],String setDifficulty,String correctAnswer){
    questions.add(new Questions(yourQuestion,yourOptions=new String[4],setDifficulty,correctAnswer));
    return "Successfully inserted";
}
String deleteQuestion(int indexToDelete){
    questions.remove(indexToDelete);
    return "Deleted Successfully";
}
String modifyQuestion(int indexToModify){
    if(indexToModify>questions.size()){
        return "Index value exceeded";
    }
    else{
        //todo
        return "Have to do";
    }
}
}
