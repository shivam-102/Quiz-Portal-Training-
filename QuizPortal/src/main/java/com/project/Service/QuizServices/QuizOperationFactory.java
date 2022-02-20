package com.project.Service.QuizServices;
import com.project.Service.Operation;
public class QuizOperationFactory {
    QuizOperationFactory(){

    }
    public static Operation getQuestionOperation(int choice){
        if(choice==1){
            return new ViewQuestionBank();
        }
        else if(choice==2){
            return new CreateQuiz();
        }
        else if(choice==3){
            return new QuizModification();
        }
        else if(choice==4){
            return new ViewQuiz();
        }
        else{
            return null;
        }
    }
}
