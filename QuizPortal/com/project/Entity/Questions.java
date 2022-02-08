package com.project.Entity;
import java.util.Arrays;
public class Questions {
private String question;
private String options[];
private String difficulty;
private String answer;
public Questions(String question, String options[], String difficulty, String answer){
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
                ", questionType=" +
                ", answer=" + answer  ;
    }
}
