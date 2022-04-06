package com.project.service.quizservice;
import com.project.Configurationn;
import com.project.service.CustomObjectFactory;
import com.project.service.Operation;
import com.project.ui.quiz.CreateQuizUI;
import com.project.ui.quiz.QuizModificationUI;
import com.project.ui.quiz.ViewQuestionBankUI;
import com.project.ui.quiz.ViewQuizUI;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class QuizOperationFactory {
    QuizOperationFactory(){

    }
    public static Operation getQuestionOperation(int choice){
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(Configurationn.class);
        CustomObjectFactory customObjectFactory=applicationContext.getBean(CustomObjectFactory.class);
        if(choice==1){
            customObjectFactory.setOperationRequired(applicationContext.getBean(ViewQuestionBankUI.class));
            Operation requiredOperation=customObjectFactory.getOperationRequired();
            return requiredOperation;
        }
        else if(choice==2){
            customObjectFactory.setOperationRequired(applicationContext.getBean(CreateQuizUI.class));
            Operation requiredOperation=customObjectFactory.getOperationRequired();
            return requiredOperation;
        }
        else if(choice==3){
            customObjectFactory.setOperationRequired(applicationContext.getBean(QuizModificationUI.class));
            Operation requiredOperation=customObjectFactory.getOperationRequired();
            return requiredOperation;
        }
        else if(choice==4){
            customObjectFactory.setOperationRequired(applicationContext.getBean(ViewQuizUI.class));
            Operation requiredOperation=customObjectFactory.getOperationRequired();
            return requiredOperation;
        }
        else{
            return null;
        }
    }
}
