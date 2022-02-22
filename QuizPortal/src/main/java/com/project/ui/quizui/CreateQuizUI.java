package com.project.ui.quizui;

import java.util.Scanner;

public class CreateQuizUI {
    Scanner scanner=new Scanner(System.in);
    public int numberOfQuestion(){
        return (Integer.parseInt(scanner.nextLine()));
    }
    public int[] questionsToBeAdded(int numberOfQuestions){
        int[] toAdd = new int[numberOfQuestions];
        for (int pointer = 0; pointer < numberOfQuestions; pointer++) {
            toAdd[pointer] = Integer.parseInt(scanner.nextLine()) - 1;
        }
        return toAdd;
    }
}
