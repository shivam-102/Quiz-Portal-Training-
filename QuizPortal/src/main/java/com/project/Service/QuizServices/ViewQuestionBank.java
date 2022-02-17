package com.project.Service.QuizServices;

import com.project.DAO.QuestionDAO;
import com.project.Service.Operation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class ViewQuestionBank implements Operation {
    private Logger logger= LogManager.getLogger(ViewQuestionBank.class);
    @Override
    public void perform() {
        QuestionDAO questionDAO = QuestionDAO.getInstance();
        ArrayList printList = questionDAO.printQuestions();
        for (int pointer = 0; pointer < printList.size(); pointer++) {
            logger.info((pointer + 1) + "." + printList.get(pointer).toString());
        }
    }
}
