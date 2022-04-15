package com.epam.quizportal.dto;

import java.util.List;

import com.epam.quizportal.entity.Questions;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
	@Override
	public String toString() {
		return "QuizDTO [code=" + code + ", questionsList=" + questionsList + "]";
	}
	
	
}
