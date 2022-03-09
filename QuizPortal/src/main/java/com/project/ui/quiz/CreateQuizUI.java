package com.project.ui.quiz;

import com.project.service.Operation;
import com.project.service.quizservice.CreateQuizService;
import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
@Component
public class CreateQuizUI implements Operation {
    @Getter
    @Setter
    private int countOfQuestions;
    private Logger logger= LogManager.getLogger(CreateQuizUI.class);
    Scanner scanner=new Scanner(System.in);
    CreateQuizService createQuizService=new CreateQuizService();
    @Override
    public void perform() {
        logger.info("How many questions you want to keep in the quiz?");
        setCountOfQuestions(Integer.parseInt(scanner.nextLine()));
        logger.info("Provide the question numbers you want to add into the quiz:");
        List<Integer> questionsList=questionsToBeAdded(getCountOfQuestions());
        createQuizService.createNewQuiz(questionsList);

    }
    public List<Integer> questionsToBeAdded(int numberOfQuestions){
        List<Integer> toAddIndex=new ArrayList<>();
        for (int pointer = 0; pointer < numberOfQuestions; pointer++) {
            toAddIndex.add(Integer.parseInt(scanner.next()));
        }
        return toAddIndex;
    }
}
