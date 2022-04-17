package com.epam.quizportal.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class QuestionDTO {
	@Getter
	@Setter
	private Integer questionId;
	@Getter
	@Setter
    private String question;
	@Getter
	@Setter
    private String difficulty;
	@Getter
	@Setter
    private Integer marks;
	@Getter
    private List<OptionsDTO> option;
    
    public QuestionDTO(Integer questionId,String question,String difficulty,Integer marks) {
    	this.questionId=questionId;
    	this.question=question;
    	this.difficulty=difficulty;
    	this.marks=marks;
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
