package com.project.service.questionservices;
import com.project.Configurationn;
import com.project.dao.QuestionDAO;
import com.project.entity.EntityFactory;
import com.project.entity.Options;
import com.project.entity.Questions;
import com.project.service.Operation;
import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class ModifyQuestion implements Operation {
     static Logger logger= LogManager.getLogger(ModifyQuestion.class);
    @Setter
    @Getter
     int questionToBeModified;
    @Setter
    @Getter
    int modifyChoice;
    QuestionDAO questionDAO=QuestionDAO.getInstance();
    Scanner scanner=new Scanner(System.in);
    EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("Quiz-Portal");
    EntityManager entityManager=entityManagerFactory.createEntityManager();
    ApplicationContext applicationContext= new AnnotationConfigApplicationContext(Configurationn.class);
    EntityFactory entityFactory=applicationContext.getBean(EntityFactory.class);

    //EntityImplementation options=entityFactory.getEntityImplementation();
    Options options=new Options();
    @Override
    public void perform()
    {

        logger.info("Enter the question you want to modify");
        questionToBeModified=Integer.parseInt(scanner.nextLine());
        logger.info("1.Question\n2.Options\n3.difficulty Level\n4.Answer");
        modifyChoice= Integer.parseInt(scanner.nextLine());
        if(modifyChoice==1){
            logger.info("Enter new Question");
            String newQuestion = setNewQuestion();
            Questions questionToModify=entityManager.find(Questions.class,questionToBeModified);
            if(questionDAO.modifyQuestion(entityManager,newQuestion,questionToModify)){
                logger.info("Question modification done!");
            }
            else{
                logger.info("No question exists");
            }

        }
        else if(modifyChoice==2){
            logger.info("Enter new Options");
            List<Options> newOptions=setOptions();
            Questions questionToModify=entityManager.find(Questions.class,questionToBeModified);
            questionDAO.modifyOptions(entityManager,newOptions,questionToModify);
        }
        else if(modifyChoice==3){
            logger.info("Enter new Difficulty");
            String newDifficulty=setNewDifficulty();
            Questions questions=entityManager.find(Questions.class,questionToBeModified);
            if(questionDAO.modifyDifficulty(entityManager,newDifficulty,questions)){
                logger.info("Difficulty modification done!");
            }
            else{
                logger.info("Question does not exist");
            }
        }
    }
    public String setNewQuestion(){
        logger.info("Enter new Question");
        return scanner.nextLine();
    }
    public String setNewDifficulty(){
        logger.info("Enter new Difficulty");
        return scanner.nextLine();
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
