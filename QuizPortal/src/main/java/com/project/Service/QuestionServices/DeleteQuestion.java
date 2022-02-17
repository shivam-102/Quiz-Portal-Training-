package com.project.Service.QuestionServices;
import com.project.DAO.QuestionDAO;
import com.project.Exceptions.QuestionDoesNotExistException;
import com.project.Service.Operation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Scanner;
public class DeleteQuestion implements Operation {
    Scanner scanner=new Scanner(System.in);
    private static Logger logger= LogManager.getLogger(DeleteQuestion.class);
    private int questionNumber;
    @Override
    public void perform() {
        setParameter();
        QuestionDAO questionDAO=QuestionDAO.getInstance();
        try {
            if (questionDAO.deleteQuestion(questionNumber - 1)) {
                logger.info("Deleted");
                logger.info(questionDAO.questions.toString());
            } else {
                throw new QuestionDoesNotExistException("Question Does Not Exist");
            }
        }catch(QuestionDoesNotExistException message){
            logger.warn(message.getMessage());
        }
    }
    public void setParameter(){
        logger.info("Please enter question number which you want to delete");
       questionNumber=(Integer.parseInt(scanner.next()));

    }
}
