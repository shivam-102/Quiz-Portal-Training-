package com.epam.quizportal.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="Options_Table")
public class Options {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int optionId;
    private String value;
    private boolean isAnswer;
    @ManyToOne
    private Questions questions;
    
    public Options() {
    	
    }
   
    
	public int getOptionId() {
		return optionId;
	}


	public void setOptionId(int optionId) {
		this.optionId = optionId;
	}


	public String getValue() {
		return value;
	}


	public void setValue(String value) {
		this.value = value;
	}


	public boolean isAnswer() {
		return isAnswer;
	}


	public void setAnswer(boolean isAnswer) {
		this.isAnswer = isAnswer;
	}


	public Questions getQuestions() {
		return questions;
	}


	public void setQuestions(Questions questions) {
		this.questions = questions;
	}


	@Override
	public String toString() {
		return "Options [optionId=" + optionId + ", value=" + value + ", isAnswer=" + isAnswer + ", questions="
				+ questions + "]";
	}
    

}
