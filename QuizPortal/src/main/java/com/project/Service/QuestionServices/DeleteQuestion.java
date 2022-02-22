package com.project.Service.QuestionServices;
import com.project.DAO.QuestionDAO;
import com.project.Exceptions.QuestionDoesNotExistException;
import com.project.Service.Operation;
import com.project.UI.QuestionUI.DeleteQuestionUI;
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
