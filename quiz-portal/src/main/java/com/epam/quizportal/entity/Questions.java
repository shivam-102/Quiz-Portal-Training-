package com.epam.quizportal.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Table(name="Questions_Table")
@Entity
public class Questions {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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


	@OneToMany(mappedBy = "questions", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Getter
    private List<Options> option;

	public Questions(Integer questionId,String question,String difficulty,Integer marks) {
		this.questionId=questionId;
		this.question=question;
		this.difficulty=difficulty;
		this.marks=marks;
	}

	public void setOption(List<Options> option) {
		System.out.println(option);
        option.forEach(options -> options.setQuestions(this));
        this.option = option;
    }


	@Override
	public String toString() {
		return "Questions [questionId=" + questionId + ", question=" + question + ", difficulty=" + difficulty
				+ ", marks=" + marks + ", option=" + option + "]";
	}
}
