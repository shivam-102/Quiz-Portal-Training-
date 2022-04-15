package com.epam.quizportal.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Getter
@Setter
@Entity
@Table(name="User")
public class User {
	@Id
	private String username;
	private String password;


}
