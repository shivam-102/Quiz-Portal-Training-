package com.project.Service.QuestionServices;
import com.project.DAO.QuestionDAO;
import com.project.Service.Operation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
public class ViewQuestions implements Operation {
    private Logger logger= LogManager.getLogger(ViewQuestions.class);
    QuestionDAO questionDAO=QuestionDAO.getInstance();
    @Override
    public void perform() {
        ArrayList printList = questionDAO.printQuestions();
        for (int pointer = 0; pointer < printList.size(); pointer++) {
            logger.info((pointer + 1) + "." + printList.get(pointer).toString());
        }
    }
}
