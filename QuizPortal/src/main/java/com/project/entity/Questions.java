package com.project.entity;
import lombok.Setter;
import java.util.Arrays;
@Setter
public class Questions {
 String question;
String[] options;
String difficulty;
 String answer;
public Questions(String question, String[] options, String difficulty, String answer){
    this.question=question;
    this.options=options;
    this.difficulty=difficulty;
    this.answer=answer;
}
    @Override
    public String toString() {
        return  "Question=" + question +
                ", options=" + Arrays.toString(options) +
                ", difficulty=" + difficulty +
                ", answer=" + answer  ;
    }
}
