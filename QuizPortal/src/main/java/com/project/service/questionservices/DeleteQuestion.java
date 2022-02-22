package com.project.service.questionservices;
import com.project.dao.QuestionDAO;
import com.project.exceptions.QuestionDoesNotExistException;
import com.project.service.Operation;
import com.project.ui.questionui.DeleteQuestionUI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class DeleteQuestion implements Operation {
    private static Logger logger= LogManager.getLogger(DeleteQuestion.class);
    QuestionDAO questionDAO=QuestionDAO.getInstance();
    DeleteQuestionUI deleteQuestionUI=new DeleteQuestionUI();
    @Override
    public void perform() {
        int questionNumber;
        questionNumber=deleteQuestionUI.setParameter();
        boolean returnValue=deleteOperation(questionNumber);
        try {
            if (returnValue) {
                logger.info("Deleted");
            } else {
                throw new QuestionDoesNotExistException("Question Does Not Exist");
            }
        }catch(QuestionDoesNotExistException message){
            logger.warn(message.getMessage());
        }
    }
    public boolean deleteOperation(int questionNumber){
        return questionDAO.deleteQuestion(questionNumber-1);
    }
}
