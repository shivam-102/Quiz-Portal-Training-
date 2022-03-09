package com.project.service.questionservices;
import com.project.dao.QuestionDAO;
import com.project.entity.Options;
import com.project.entity.Questions;
import com.project.service.Operation;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
class AddQuestionTest {
    @Mock
    QuestionDAO questionDAO;
    @Mock
    EntityManager entityManager;

    @Test
    void perform() {
        AddQuestion addQuestion=new AddQuestion(questionDAO);

        addQuestion.perform();
        //verify(addQuestion,times(1)).perform();
        verify(questionDAO).insert(entityManager,any(Questions.class));
    }

    @Test
    void getParameters() {
        AddQuestion addQuestion=mock(AddQuestion.class);
        addQuestion.getParameters();
        verify(addQuestion,times(1)).getParameters();
    }

    @Test
    void getQuestion() {
        AddQuestion addQuestion=mock(AddQuestion.class);
        addQuestion.setQuestion("Question 1");
        when(addQuestion.getQuestion()).thenReturn("Question 1");
        assertEquals("Question 1",addQuestion.getQuestion());

    }

    @Test
    void getDifficulty() {
        //given
        AddQuestion addQuestion=mock(AddQuestion.class);
        addQuestion.setDifficulty("easy");
        when(addQuestion.getDifficulty()).thenReturn("easy");
        assertEquals("easy",addQuestion.getDifficulty());
    }
    @Test
    void getOptions() {
        //given
        Options options=new Options();
        options.setValue("Answer");
        options.setAnswer(false);
        options.setQuestions(new Questions(3,"New Question","easy"));
        AddQuestion addQuestion=new AddQuestion();
        List<Options> optionsList=new ArrayList<>();
        optionsList.add(options);
        addQuestion.setOptions(optionsList);
        assertEquals(optionsList,addQuestion.getOptions());

    }


    @Test
    void setQuestion() {
        AddQuestion addQuestion=new AddQuestion();
        addQuestion.setQuestion("Question 1");
        assertTrue(addQuestion.getQuestion().equals("Question 1"));
    }

    @Test
    void setDifficulty() {
        AddQuestion addQuestion=new AddQuestion();
        addQuestion.setDifficulty("HARD");
        assertTrue(addQuestion.getDifficulty().equals("HARD"));
    }

    @Test
    void setOptions() {
        Options options=new Options();
        options.setValue("Answer");
        options.setAnswer(false);
        options.setQuestions(new Questions(3,"New Question","easy"));
        AddQuestion addQuestion=new AddQuestion();
        List<Options> optionsList=new ArrayList<>();
        optionsList.add(options);
        addQuestion.setOptions(optionsList);
        assertTrue(addQuestion.getOptions().equals(optionsList));

    }
}