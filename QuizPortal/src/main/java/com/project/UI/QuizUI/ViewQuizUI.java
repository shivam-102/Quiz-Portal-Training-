package com.project.UI.QuizUI;

import java.util.Scanner;

public class ViewQuizUI {
    Scanner scanner=new Scanner(System.in);
    public int getQuizCode(){
        return (Integer.parseInt(scanner.nextLine()));
    }
}
