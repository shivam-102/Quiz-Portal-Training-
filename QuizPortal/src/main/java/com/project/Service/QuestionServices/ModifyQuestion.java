package com.project.Service.QuestionServices;
import com.project.DAO.QuestionDAO;
import com.project.Exceptions.InvalidChoiceException;
import com.project.Service.Operation;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Scanner;
@Setter
public class ModifyQuestion implements Operation {
    private static Logger logger= LogManager.getLogger(ModifyQuestion.class);
    private int questionToBeModified;
    private int modifyChoice;
    QuestionDAO questionDAO=QuestionDAO.getInstance();
    Scanner scanner=new Scanner(System.in);
    @Override
    public void perform() {
        try {
            getParameters();
            modifyChoice= Integer.parseInt(scanner.nextLine());
            if (modifyChoice == 1) {
                logger.info("Enter new Question");
                String newQuestion = setNewQuestion();
                questionDAO.modifyQuestion(newQuestion,questionToBeModified);
                logger.info("Question Modification Done");
            } else if (modifyChoice == 2) {
                String[] newOptions = setOptions();
                questionDAO.modifyOptions(newOptions,questionToBeModified);
                logger.info("Option Modification done");
            } else if (modifyChoice == 3) {
                String newDifficulty = setDifficulty();
                questionDAO.modifyDifficulty(newDifficulty,questionToBeModified);
                logger.info("Difficulty Modification done");
            } else if (modifyChoice == 4) {
                String newAnswer = setAnswer();
                questionDAO.modifyAnswer(newAnswer,questionToBeModified);
                logger.info("Answer Modification done");
            } else {
                throw new InvalidChoiceException("Enter a valid choice");
            }
        }catch(NumberFormatException message){
            logger.error(message);
        }catch (InvalidChoiceException message){
            logger.error(message);
        }
    }
    public void getParameters(){
        logger.info("Enter the question you want to modify");
        setQuestionToBeModified(Integer.parseInt(scanner.nextLine()));
        logger.info("1.Question\n2.Options\n3.difficulty Level\n4.Answer");

    }
    public String setNewQuestion(){
        logger.info("Enter new Question");
        return scanner.nextLine();
    }

    public String[] setOptions(){
        logger.info("Enter options");
        String[] newOptions = new String[4];
        for (int pointer = 0; pointer < 4; pointer++) {
            newOptions[pointer] = scanner.nextLine();
        }
        return newOptions;
    }
    public String setDifficulty(){
        logger.info("Enter the new difficulty");
        return scanner.nextLine();
    }
    public String setAnswer(){
        logger.info("Enter new Answer");
        return scanner.nextLine();
    }
}
