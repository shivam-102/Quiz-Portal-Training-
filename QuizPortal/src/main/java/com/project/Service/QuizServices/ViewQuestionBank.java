package com.project.Service.QuizServices;

import com.project.DAO.QuestionDAO;
import com.project.Entity.Questions;
import com.project.Service.Operation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class ViewQuestionBank implements Operation {
    private Logger logger= LogManager.getLogger(ViewQuestionBank.class);
    QuestionDAO questionDAO = QuestionDAO.getInstance();
    @Override
    public void perform() {
        display();

    }
    boolean display(){
        ArrayList<Questions> printList = questionDAO.printQuestions();
        for (int pointer = 0; pointer < printList.size(); pointer++) {
            logger.info(new StringBuilder().append(pointer + 1).append(".").append(printList.get(pointer).toString()).toString());
        }
        return true;
    }
}
