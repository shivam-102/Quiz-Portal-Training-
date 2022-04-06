package com.project.service.questionservice;
import com.project.Configurationn;
import com.project.service.CustomObjectFactory;
import com.project.service.Operation;
import com.project.ui.question.AddQuestionUI;
import com.project.ui.question.DeleteQuestionUI;
import com.project.ui.question.ModifyQuestionUI;
import com.project.ui.question.ViewQuestions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class OperationFactory {
    OperationFactory(){
    }
    public static Operation getOperation(int choice) {
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(Configurationn.class);
        CustomObjectFactory customObjectFactory=applicationContext.getBean(CustomObjectFactory.class);
        if (choice == 1) {
            customObjectFactory.setOperationRequired(applicationContext.getBean(ViewQuestions.class));
            Operation requiredOperation=customObjectFactory.getOperationRequired();
            return requiredOperation;
        } else if (choice == 2) {
            customObjectFactory.setOperationRequired(applicationContext.getBean(AddQuestionUI.class));
            Operation requiredOperation= customObjectFactory.getOperationRequired();
            return requiredOperation;
        } else if (choice == 3) {
            customObjectFactory.setOperationRequired(applicationContext.getBean(DeleteQuestionUI.class));
            Operation requiredOperation= customObjectFactory.getOperationRequired();
            return requiredOperation;
        } else if (choice == 4) {
            customObjectFactory.setOperationRequired(applicationContext.getBean(ModifyQuestionUI.class));
            Operation requiredOperation= customObjectFactory.getOperationRequired();
            return requiredOperation;
        } else {
            return null;
        }
    }
}
