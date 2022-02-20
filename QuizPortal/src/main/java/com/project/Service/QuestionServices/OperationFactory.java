package com.project.Service.QuestionServices;
import com.project.Service.Operation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OperationFactory {
    OperationFactory(){

    }
    public static Operation getOperation(int choice) {
            if (choice == 1) {
                return new ViewQuestions();
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

