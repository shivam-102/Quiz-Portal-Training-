package com.project.ui.question;
import com.project.service.Operation;
import com.project.service.questionservice.DeleteQuestionService;
import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;
@Component
public class DeleteQuestionUI implements Operation {
    @Getter
    @Setter
    private int questionToBeDeleted;
    EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("Quiz-Portal");
    EntityManager entityManager=entityManagerFactory.createEntityManager();
    private static Logger logger= LogManager.getLogger(DeleteQuestionUI.class);
    DeleteQuestionService deleteQuestionService=new DeleteQuestionService();
    Scanner scanner=new Scanner(System.in);
    @Override
    public void perform() {
        logger.info("Please enter question number which you want to delete");
        setQuestionToBeDeleted(Integer.parseInt(scanner.nextLine()));
        boolean response=deleteQuestionService.deleteOperation(getQuestionToBeDeleted());
        if(response==true){
            logger.info("Question deleted successfully");
        }
        else{
            logger.info("Question does not exist! Please enter a valid question");
        }
    }
}
