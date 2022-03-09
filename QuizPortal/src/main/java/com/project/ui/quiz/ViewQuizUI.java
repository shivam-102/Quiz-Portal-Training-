package com.project.ui.quiz;

import com.project.entity.Questions;
import com.project.service.Operation;
import com.project.service.quizservice.ViewQuizService;
import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;
@Component
public class ViewQuizUI implements Operation {
    @Getter
    @Setter
    private int code;
    private Logger logger= LogManager.getLogger(ViewQuizUI.class);
    Scanner scanner=new Scanner(System.in);
    ViewQuizService viewQuizService=new ViewQuizService();
    @Override
    public void perform() {
        logger.info("Provide the Quiz code");
        setCode(Integer.parseInt(scanner.nextLine()));
        List<Questions> questionsList=viewQuizService.display(getCode());
        questionsList.forEach(question ->
                logger.info(question)
        );
    }
}
