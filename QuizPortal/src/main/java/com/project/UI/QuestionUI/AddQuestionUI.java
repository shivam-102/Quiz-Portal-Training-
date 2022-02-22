package com.project.UI.QuestionUI;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class AddQuestionUI {
     static Logger logger= LogManager.getLogger(AddQuestionUI.class);
    Scanner scanner=new Scanner(System.in);
    public String question(){
        logger.info("Please enter the question");
        return (scanner.nextLine());
    }
    public String[] options(){
        logger.info("Enter the options you want to keep");
        String[] options =new String[4];
        for(int input=0;input< options.length;input++){
            logger.info("Enter option");
            logger.info(input+1);
            options[input]=scanner.nextLine();
        }
        return options;
    }
    public String difficulty(){
        logger.info("Enter the difficulty level");
        return (scanner.nextLine());
    }
    public String answer(){
        logger.info("Enter the correct answer");
        return (scanner.nextLine());
    }
}
