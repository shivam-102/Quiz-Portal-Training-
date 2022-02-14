package com.project.Service;
import com.project.DAO.QuestionDAO;
import com.project.Exceptions.InvalidException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Scanner;

public class QuestionService {
    Scanner scanner = new Scanner(System.in);
    QuestionDAO questionDAO = new QuestionDAO();
    private Logger logger= LogManager.getLogger(QuestionService.class);

    public void view() {
        ArrayList printList = questionDAO.printQuestions();
        for (int pointer = 0; pointer < printList.size(); pointer++) {
            logger.info((pointer + 1) + "." + printList.get(pointer).toString());
        }
    }

    public String addQuestion(String question, String[] options, String difficulty, String questionAnswer) {
        if (questionDAO.addQuestion(question, options, difficulty, questionAnswer)) {
            return "Added Successfully";
        } else {
            return "Cannot add it!";
        }
    }

    public String deleteQuestion(int index) {
        if (questionDAO.deleteQuestion(index)) {
            return "String deleted successfully";
        }
        return "Cannot delete that given question";
    }

    public String modify(int questionToBeModified,int choice){
        try {
            if (choice == 1) {
                logger.info("Enter the modified Question");
                questionDAO.modifyQuestion(scanner.nextLine(), questionToBeModified);
                return "Question modification done";
            } else if (choice == 2) {
                logger.info("Enter options");
                String[] newOptions = new String[4];
                for (int pointer = 0; pointer < 4; pointer++) {
                    newOptions[pointer] = scanner.nextLine();

                }
                questionDAO.modifyOptions(newOptions, questionToBeModified);
                return "Options modification done";
            } else if (choice == 3) {
                logger.info("Enter the modified Difficulty");
                questionDAO.modifyDifficulty(scanner.nextLine(), questionToBeModified);
                return "Difficulty modification done";
            } else if (choice == 4) {
                logger.info("Enter the modified Answer");
                questionDAO.modifyAnswer(scanner.nextLine(), questionToBeModified);
                return "Answer modification done";
            }
            else{
                throw new InvalidException("Enter valid option");

            }
        }catch(InvalidException message){
            logger.info("Invalid option selected");
            logger.info(message.getMessage());
        }
        return "Valid option";
    }
}
