package com.epam.quizportal.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="Options_Table")
public class Options {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int optionId;
    private String value;
    private boolean isAnswer;
    @ManyToOne
    private Questions questions;

    public Options(int optionId, String value, boolean isAnswer) {
        this.optionId = optionId;
        this.value = value;
        this.isAnswer = isAnswer;

    }


}
