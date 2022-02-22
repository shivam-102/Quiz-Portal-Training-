package com.project.service.questionservices;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class AddQuestionTest {
    AddQuestion addQuestion=new AddQuestion();
    @Test
    void addQuestion() {
        assertEquals(true,addQuestion.addQuestion("Who are you?",new String[]{"a","b","c","d"},"easy","a"));

    }
    @Test
    void setQuestion(){
        AddQuestion addQuestion= mock(AddQuestion.class);
        doNothing().when(addQuestion).setQuestion(anyString());
        addQuestion.setQuestion("Hehe");
        verify(addQuestion,times(1)).setQuestion("Hehe");
    }

    @Test
    void setAddOptions(){
        AddQuestion addQuestion= mock(AddQuestion.class);
        doNothing().when(addQuestion).setQuestion(anyString());
        addQuestion.setOptions( new String[]{"6", "7", "8", "9"});
        verify(addQuestion,times(1)).setOptions(new String[]{"6", "7", "8", "9"});
    }

    @Test
    void setDifficulty(){
        AddQuestion addQuestion= mock(AddQuestion.class);
        doNothing().when(addQuestion).setDifficulty(anyString());
        addQuestion.setDifficulty("easy");
        verify(addQuestion,times(1)).setDifficulty("easy");
    }

    @Test
    void setAnswer(){
        AddQuestion addQuestion= mock(AddQuestion.class);
        doNothing().when(addQuestion).setQuestionAnswer(anyString());
        addQuestion.setQuestionAnswer("answer");
        verify(addQuestion,times(1)).setQuestionAnswer("answer");
    }
}