package com.project.Service.QuizServices;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ViewQuestionBankTest {
    ViewQuestionBank viewQuestionBank=new ViewQuestionBank();
    @Test
    void display() {
        assertEquals(true,viewQuestionBank.display());
    }
}