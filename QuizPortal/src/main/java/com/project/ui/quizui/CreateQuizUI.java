package com.project.ui.quizui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreateQuizUI {
    Scanner scanner=new Scanner(System.in);
    public int numberOfQuestion(){
        return (Integer.parseInt(scanner.nextLine()));
    }
    public List<Integer> questionsToBeAdded(int numberOfQuestions){
        List<Integer> toAddIndex=new ArrayList<>();
        for (int pointer = 0; pointer < numberOfQuestions; pointer++) {
            toAddIndex.add(Integer.parseInt(scanner.next()));
        }
        return toAddIndex;
    }
}
