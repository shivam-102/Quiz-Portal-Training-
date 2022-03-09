package com.project.ui.question;

import com.project.entity.Options;
import com.project.service.Operation;
import com.project.service.questionservice.AddQuestionService;
import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
@Component
public class AddQuestionUI implements Operation {
    @Getter
    @Setter
    private String question;
    @Getter
    @Setter
    private String difficulty;
    @Getter
    @Setter
    private List<Options> options;
    Options option=new Options();
    static Logger logger= LogManager.getLogger(AddQuestionUI.class);
    AddQuestionService addQuestionService=new AddQuestionService();
    Scanner scanner=new Scanner(System.in);
    @Override
    public void perform() {
        logger.info("Please enter the question:");
        setQuestion(scanner.nextLine());
        setOptions();
        logger.info("Please enter the difficulty");
        setDifficulty(scanner.nextLine());
        if(addQuestionService.addNewQuestion(getQuestion(),getOptions(),getDifficulty()))
            logger.info("Question added");
        else
            logger.info("Unable to add questions!");
    }
    void setOptions(){
        List<Options> optionsList=new ArrayList<>();
        logger.info("How many options you want to add to this question?");
        int numberOfOptions=Integer.parseInt(scanner.nextLine());
        int initial;
        String answer;
        for(initial=0;initial<numberOfOptions;initial++){
            logger.info("Type your option {}",(initial+1));
            option.setValue(scanner.nextLine());
            logger.info("Is this your answer(yes/no)?");
            answer=scanner.nextLine();
            if(answer.equals("yes")){
                option.setAnswer(true);
            }
            else{
                option.setAnswer(false);
            }
            optionsList.add(option);

        }
        setOptions(optionsList);
    }
}
