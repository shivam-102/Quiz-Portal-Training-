package com.project.service.questionservices;
import com.project.service.Operation;

public class OperationFactory {
    OperationFactory(){

    }
    public static Operation getOperation(int choice) {
        if (choice == 1) {
            return new ViewQuestionAvailable();
        } else if (choice == 2) {
            return new AddQuestion();
        } else if (choice == 3) {
            return new DeleteQuestion();
        } else if (choice == 4) {
            return new ModifyQuestion();
        } else {
            return null;
        }
    }
}
