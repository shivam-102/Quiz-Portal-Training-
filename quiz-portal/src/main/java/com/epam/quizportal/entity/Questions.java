package com.epam.quizportal.entity;


import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name="Questions_Table")
@Entity
public class Questions {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer questionId;
    private String question;
    private String difficulty;
    private Integer marks;
    
    public Questions(Integer questionId,String question,String difficulty,Integer marks) {
    	this.questionId=questionId;
    	this.question=question;
    	this.difficulty=difficulty;
    	this.marks=marks;
    	
    }
   
    @OneToMany(mappedBy = "questions", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Options> option;
    public Questions() {
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
	
	public List<Options> getOption() {
		return option;
	}


	public void setOption(List<Options> option) {
        option.forEach(options -> options.setQuestions(this));
        this.option = option;
    }


	@Override
	public String toString() {
		return "Questions [questionId=" + questionId + ", question=" + question + ", difficulty=" + difficulty
				+ ", marks=" + marks + ", option=" + option + "]";
	}
}
