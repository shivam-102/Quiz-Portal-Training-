package com.epam.quizportal.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Quiz")
public class Quiz {
	@Id
    private int code;
    @ManyToMany
    private List<Questions> questionsList;
    public Quiz(){

    }
    public Quiz(int code,List<Questions> questionsList){
       
        this.code=code;
        this.questionsList=questionsList;
    }
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
	@Override
	public String toString() {
		return "Quiz [code=" + code + ", questionsList=" + questionsList + "]";
	}
    
}
