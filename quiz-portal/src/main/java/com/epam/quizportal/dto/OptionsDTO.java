package com.epam.quizportal.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OptionsDTO {
	
	int optionId;
    String value;
    boolean isAnswer;
    QuestionDTO questions;

	public OptionsDTO(int optionId, String value, boolean isAnswer) {
		this.optionId = optionId;
		this.value = value;
		this.isAnswer = isAnswer;
	}

	@Override
	public String toString() {
		return "OptionsDTO [optionId=" + optionId + ", value=" + value + ", isAnswer=" + isAnswer + ", questions="
				+ questions + "]";
	}
    
    

}
