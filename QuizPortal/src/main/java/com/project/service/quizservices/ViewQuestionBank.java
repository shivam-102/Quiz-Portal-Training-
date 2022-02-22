package com.project.service.quizservices;

import com.project.dao.QuestionDAO;
import com.project.entity.Questions;
import com.project.service.Operation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ViewQuestionBank implements Operation {
    private Logger logger= LogManager.getLogger(ViewQuestionBank.class);
    QuestionDAO questionDAO = QuestionDAO.getInstance();
    @Override
    public void perform() {
        display();

    }
    boolean display(){
        List<Questions> printList = questionDAO.printQuestions();
        for (int pointer = 0; pointer < printList.size(); pointer++) {
            logger.info(new StringBuilder().append(pointer + 1).append(".").append(printList.get(pointer).toString()).toString());
        }
        return true;
    }
}
