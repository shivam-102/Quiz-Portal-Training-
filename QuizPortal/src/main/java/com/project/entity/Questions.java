package com.project.entity;
import lombok.Getter;
import org.springframework.stereotype.Component;
import javax.persistence.*;
import java.util.List;
@Getter
@Entity
@Table(name = "Question_Table")
public class Questions implements EntityImplementation {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 int questionId;
 String question;
 String difficulty;
 public Questions(int questionId, String question,String difficulty){
  super();
  this.questionId=questionId;
  this.question=question;
  this.difficulty=difficulty;
 }
 @OneToMany(mappedBy = "questions", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
 private List<Options> option;
 public Questions() {
 }
 public void setQuestion(String question) {
  this.question = question;
 }
 public void setDifficulty(String difficulty) {
  this.difficulty = difficulty;
 }
 public void setOption(List<Options> option) {
  option.forEach(options -> options.setQuestions(this));
  this.option = option;
 }

 @Override
 public String toString() {
  return "Questions{" +
          "id=" + questionId +
          ", question='" + question + '\'' +
          ", difficulty='" + difficulty + '\'' +
          '}';
 }
}

