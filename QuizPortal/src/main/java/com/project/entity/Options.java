package com.project.entity;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
@Entity
@Table(name = "options")
@Getter
public class Options implements EntityImplementation{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int optionId;
    private String value;
    private boolean isAnswer;
    @ManyToOne
    private Questions questions;



    public void setValue(String value) {
        this.value = value;
    }

    public void setAnswer(boolean answer) {
        isAnswer = answer;
    }

    public void setQuestions(Questions questions) {
        this.questions = questions;
    }
}
