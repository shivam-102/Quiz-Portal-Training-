package com.project.ui.question;
import com.project.entity.Questions;
import com.project.service.Operation;
import com.project.service.questionservice.ViewQuestionService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import java.util.List;
@Component
public class ViewQuestions implements Operation {
    private Logger logger= LogManager.getLogger(ViewQuestions.class);
    ViewQuestionService viewQuestionService=new ViewQuestionService();
    @Override
    public void perform() {
        List<Questions> questionsList=viewQuestionService.display();
        questionsList.forEach(question -> logger.info(question));
    }
}
