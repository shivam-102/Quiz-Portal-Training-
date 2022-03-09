package com.project.ui.question;
import com.project.entity.Options;
import com.project.service.Operation;
import com.project.service.questionservice.ModifyQuestionService;
import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
@Component
public class ModifyQuestionUI implements Operation {
    private static Logger logger = LogManager.getLogger(ModifyQuestionUI.class);
    @Getter
    @Setter
    int questionToBeModified;
    @Getter
    @Setter
    int modifyChoice;
    Options options=new Options();
    ModifyQuestionService modifyQuestionService=new ModifyQuestionService();
    Scanner scanner=new Scanner(System.in);
    @Override
    public void perform() {
        logger.info("Enter the question you want to modify");
        setQuestionToBeModified(Integer.parseInt(scanner.nextLine()));
        logger.info("1.Question\n2.Options\n3.difficulty Level\n");
        modifyChoice= Integer.parseInt(scanner.nextLine());
        if(modifyChoice==1){
            logger.info("Enter new Question");
            String newQuestion = scanner.nextLine();
            if(modifyQuestionService.modifyQuestion(getQuestionToBeModified(),newQuestion)){
                logger.info("Question modification done!");
            }
            else{
                logger.info("No question exists");
            }
        }
        else if(modifyChoice==2){
            logger.info("Enter new Options");
            List<Options> newOptions=setOptions();
            if(modifyQuestionService.modifyOptions(getQuestionToBeModified(),newOptions)){
                logger.info("Options modification done!");
            }
            else{
                logger.info("No question exists");
            }
        }
        else if(modifyChoice==3){
            logger.info("Enter new Difficulty");
            String newDifficulty=scanner.nextLine();
            if(modifyQuestionService.modifyDifficulty(questionToBeModified,newDifficulty)){
                logger.info("Difficulty modification done!");
            }
            else{
                logger.info("Question does not exist");
            }
        }
    }
    public List<Options> setOptions(){
        List<Options> newOptionList=new ArrayList<>();
        logger.info("Please enter the number of options you want to Keep");
        int numberOfOptions=Integer.parseInt(scanner.next());
        int initial;
        String answer;
        for(initial=0;initial<numberOfOptions;initial++){
            logger.info("Type your option {}",(initial+1));
            options.setValue(scanner.nextLine());
            logger.info("Is this your answer(yes/no)?");
            answer=scanner.nextLine();
            if(answer.equals("yes")){
                options.setAnswer(true);
            }
            else{
                options.setAnswer(false);
            }
            newOptionList.add(options);
        }
        return newOptionList;
    }
}
