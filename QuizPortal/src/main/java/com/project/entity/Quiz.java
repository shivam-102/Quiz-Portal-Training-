package com.project.entity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Getter
@Setter
@Entity
@Table(name = "Quiz")
public class Quiz implements EntityImplementation{
    @Id
    int code;
    @ManyToMany
    List<Questions> questionsList;
    public Quiz(){

    }
    public Quiz(int code,List<Questions> questionsList){
        super();
        this.code=code;
        this.questionsList=questionsList;
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "code=" + code +
                ", questionsList=" + questionsList +
                '}';
    }
}
