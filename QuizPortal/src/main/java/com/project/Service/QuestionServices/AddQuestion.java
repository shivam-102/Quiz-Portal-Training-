package com.project.Service.QuestionServices;
import com.project.DAO.QuestionDAO;
import com.project.Service.Operation;
import com.project.UI.QuestionUI.AddQuestionUI;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;
@Setter
public class AddQuestion implements Operation {
    AddQuestionUI addQuestionUI=new AddQuestionUI();
    private static Logger logger= LogManager.getLogger(AddQuestion.class);
    Scanner scanner=new Scanner(System.in);
    private String question;
    private String[] options;
    private String difficulty;
    private String questionAnswer;
    QuestionDAO questionDAO=QuestionDAO.getInstance();
    @Override
    public void perform() {
        getParameters();
        boolean returnValue=addQuestion(question,options,difficulty,questionAnswer);
        if(returnValue){
            logger.info("Question has been added");
        }
        else{
            logger.info("Failed to add question");
        }
    }
    void getParameters(){
        setQuestion(addQuestionUI.question());
        setOptions(addQuestionUI.options());
        setDifficulty(addQuestionUI.difficulty());
        setQuestionAnswer(addQuestionUI.answer());
    }
    public boolean addQuestion(String question,String[] options,String difficulty,String questionAnswer){
        return questionDAO.addQuestion(question, options, difficulty, questionAnswer);
    }

}
