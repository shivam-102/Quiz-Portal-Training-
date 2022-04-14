package com.epam.quizportal.dto;

import com.epam.quizportal.entity.Questions;

public class OptionsDTO {
	
	int optionId;
    String value;
    boolean isAnswer;
    QuestionDTO questions;
    public OptionsDTO() {
    	
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
	public QuestionDTO getQuestions() {
		return questions;
	}
	public void setQuestions(QuestionDTO questions) {
		this.questions = questions;
	}
	@Override
	public String toString() {
		return "OptionsDTO [optionId=" + optionId + ", value=" + value + ", isAnswer=" + isAnswer + ", questions="
				+ questions + "]";
	}
    
    

}
