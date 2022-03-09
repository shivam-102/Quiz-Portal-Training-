package com.project.ui.questionui;
import com.project.entity.Options;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class AddQuestionUI {
    Options options=new Options();
     static Logger logger= LogManager.getLogger(AddQuestionUI.class);
    Scanner scanner=new Scanner(System.in);
    public String question(){
        logger.info("Please enter the question");
        return (scanner.nextLine());
    }

    public List<Options> options(){
        List<Options> optionsList=new ArrayList<>();
        logger.info("How many options you want to add to this question?");
        int numberOfOptions=Integer.parseInt(scanner.nextLine());
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
            optionsList.add(options);

        }
        return optionsList;
    }
    public String difficulty(){
        logger.info("Enter the difficulty level");
        return (scanner.nextLine());
    }
}
