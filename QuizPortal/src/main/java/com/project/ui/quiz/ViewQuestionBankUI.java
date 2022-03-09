package com.project.ui.quiz;

import com.project.entity.Questions;
import com.project.service.Operation;
import com.project.service.quizservice.ViewQuestionBankService;
import com.project.service.quizservices.ViewQuestionBank;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ViewQuestionBankUI implements Operation {
    private Logger logger= LogManager.getLogger(ViewQuestionBankUI.class);
    ViewQuestionBankService viewQuestionBankService=new ViewQuestionBankService();
    @Override
    public void perform() {
        List<Questions> questionsInTheQuestionBank=viewQuestionBankService.display();
        questionsInTheQuestionBank.forEach(question ->
                logger.info(question)
        );
    }
}
