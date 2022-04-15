package com.epam.quizportal.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Quiz")
public class Quiz {
	@Id
    private int code;
    @ManyToMany
    private List<Questions> questionsList;
	@Override
	public String toString() {
		return "Quiz [code=" + code + ", questionsList=" + questionsList + "]";
	}
    
}
