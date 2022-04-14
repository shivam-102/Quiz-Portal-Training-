package com.epam.quizportal.dto;

import java.util.List;

import com.epam.quizportal.entity.Questions;

public class QuizDTO {
	int code;
	List<Questions> questionsList;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public List<Questions> getQuestionsList() {
		return questionsList;
	}
	public void setQuestionsList(List<Questions> questionsList) {
		this.questionsList = questionsList;
	}
	public QuizDTO(int code, List<Questions> questionsList) {
		super();
		this.code = code;
		this.questionsList = questionsList;
	}
	public QuizDTO() {
		super();
	}
	@Override
	public String toString() {
		return "QuizDTO [code=" + code + ", questionsList=" + questionsList + "]";
	}
	
	
}
