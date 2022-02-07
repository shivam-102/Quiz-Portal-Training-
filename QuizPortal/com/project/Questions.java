package com.project;

import java.util.Arrays;

public class Questions {
private String question;
private String options[];
private String difficulty;
private String questionType;
private String answer;
Questions(String question,String options[],String difficulty,String answer){
    this.question=question;
    this.options=options;
    this.difficulty=difficulty;
    this.answer=answer;
}

    @Override
    public String toString() {
        return "Questions{" +
                "question='" + question + '\'' +
                ", options=" + Arrays.toString(options) +
                ", difficulty='" + difficulty + '\'' +
                ", questionType='" + questionType + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
