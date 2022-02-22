package com.project.Service.QuizServices;
import com.project.DAO.QuizDAO;
import com.project.Exceptions.InvalidChoiceException;
import com.project.Service.Operation;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Scanner;
@Setter
public class QuizModification implements Operation {
     int code;
     static Logger logger= LogManager.getLogger(QuizModification.class);
    Scanner scanner=new Scanner(System.in);
    QuizDAO quizDAO=QuizDAO.getInstance();
    @Override
    public void perform() {
        getCode();
        if(quizDAO.checkIfThere(code)){
            while(true){
                try {
                    questionOperationList();
                    int internalChoice = Integer.parseInt(scanner.nextLine());
                    if (internalChoice == 0) {
                        break;
                    } else if (internalChoice == 1) {
                        addQuestion();
                    } else if (internalChoice == 2) {
                        deleteOperation();
                    }
                    else{
                        throw new InvalidChoiceException("Please choose correct choice");
                    }
                }catch(InvalidChoiceException message){
                    logger.warn(message.getMessage());
                }
            }
        }
    }
    void getCode(){
        logger.info("Enter the quiz code you want modify");
        setCode(Integer.parseInt(scanner.nextLine()));
    }
    void questionOperationList(){
        logger.info("Do you want to add or delete any question in this quiz?");
        logger.info("Press 1 to add question");
        logger.info("Press 2 to delete question");
        logger.info("Press 0 to exit");
    }
    void addQuestion(){
        logger.info("Press the question number you want to add");
        int questionNumber = Integer.parseInt(scanner.nextLine());
        quizDAO.addQuestion(questionNumber, code);
        logger.info("Question added");
    }
    void deleteOperation(){
        logger.info("Enter the question number you want to delete");
        if (quizDAO.deleteQuestion(Integer.parseInt(scanner.nextLine()) - 1, code)) {
            logger.info("Question deleted");
        }
        else{
            logger.info("Not deleted");
        }
    }

}
