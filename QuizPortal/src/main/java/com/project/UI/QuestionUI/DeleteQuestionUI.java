package com.project.UI.QuestionUI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Scanner;
public class DeleteQuestionUI {
    int questionToBeDeleted;
    private static Logger logger= LogManager.getLogger(DeleteQuestionUI.class);
    Scanner scanner=new Scanner(System.in);
    public int setParameter(){
        logger.info("Please enter question number which you want to delete");
        questionToBeDeleted=Integer.parseInt(scanner.nextLine());
        return questionToBeDeleted;
    }
}
