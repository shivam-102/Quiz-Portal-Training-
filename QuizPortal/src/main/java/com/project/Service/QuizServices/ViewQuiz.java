package com.project.Service.QuizServices;
import com.project.DAO.QuizDAO;
import com.project.Service.Operation;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Scanner;
@Setter
public class ViewQuiz implements Operation {
    private int code;
    private Logger logger= LogManager.getLogger(ViewQuiz.class);
    QuizDAO quizDAO=QuizDAO.getInstance();
    Scanner scanner=new Scanner(System.in);
    @Override
    public void perform() {
        getCode();
        ArrayList listToPrint= quizDAO.quiz.get(code);
        for(int pointer=0;pointer<listToPrint.size();pointer++)
        {
            logger.info( (pointer+1)+"."+listToPrint.get(pointer).toString());
        }
    }
    void getCode(){
        logger.info("Provide the Quiz code");
        setCode(Integer.parseInt(scanner.nextLine()));
    }
}
