package com.project.service.questionservices;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ModifyQuestionTest {

    @Test
    void perform() {
        ModifyQuestion modifyQuestion=mock(ModifyQuestion.class);
        modifyQuestion.perform();
        verify(modifyQuestion,times(1)).perform();
    }

    @Test
    void setNewQuestion() {
        ModifyQuestion modifyQuestion=mock(ModifyQuestion.class);
        assertEquals(null,modifyQuestion.setNewQuestion());

    }

    @Test
    void setNewDifficulty() {
        ModifyQuestion modifyQuestion=mock(ModifyQuestion.class);
        assertEquals(null,modifyQuestion.setNewDifficulty());
    }
    @Test
    void getQuestionToBeModified() {
        ModifyQuestion modifyQuestion=spy(ModifyQuestion.class);
        modifyQuestion.setModifyChoice(3);
        when(modifyQuestion.getQuestionToBeModified()).thenReturn(3);
        assertEquals(3,modifyQuestion.getModifyChoice());
    }

    @Test
    void getModifyChoice() {
    }

    @Test
    void setQuestionToBeModified() {
        ModifyQuestion modifyQuestion=spy(ModifyQuestion.class);
        modifyQuestion.setQuestionToBeModified(2);
        assertEquals(2,modifyQuestion.getQuestionToBeModified());
    }

    @Test
    void setModifyChoice() {
        ModifyQuestion modifyQuestion=spy(ModifyQuestion.class);
        modifyQuestion.setModifyChoice(5);
        assertEquals(5,modifyQuestion.getModifyChoice());

    }
}