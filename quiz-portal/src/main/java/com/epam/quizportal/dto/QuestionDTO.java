package com.epam.quizportal.dto;

import java.util.List;

import com.epam.quizportal.entity.Options;

public class QuestionDTO {
	private Integer questionId;
    private String question;
    private String difficulty;
    private Integer marks;
    private List<OptionsDTO> option;
    
    public QuestionDTO(Integer questionId,String question,String difficulty,Integer marks) {
    	this.questionId=questionId;
    	this.question=question;
    	this.difficulty=difficulty;
    	this.marks=marks;
    	}
    
    public QuestionDTO(){
    	
    }
	public Integer getQuestionId() {
		return questionId;
	}


	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}


	public String getQuestion() {
		return question;
	}


	public void setQuestion(String question) {
		this.question = question;
	}


	public String getDifficulty() {
		return difficulty;
	}


	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}


	public Integer getMarks() {
		return marks;
	}


	public void setMarks(Integer marks) {
		this.marks = marks;
	}


	public List<OptionsDTO> getOption() {
		return option;
	}


	public void setOption(List<OptionsDTO> option) {
		option.forEach(options -> options.setQuestions(this));
		this.option = option;
	}


	@Override
	public String toString() {
		return "QuestionDTO [questionId=" + questionId + ", question=" + question + ", difficulty=" + difficulty
				+ ", marks=" + marks + ", option=" + option + "]";
	}
    
    
}
