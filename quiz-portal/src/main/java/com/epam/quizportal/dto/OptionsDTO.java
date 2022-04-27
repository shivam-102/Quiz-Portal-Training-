package com.epam.quizportal.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
	@JsonIgnore
    QuestionDTO questions;

	public OptionsDTO(int optionId, String value, boolean isAnswer) {
		this.optionId = optionId;
		this.value = value;
		this.isAnswer = isAnswer;
	}

}
