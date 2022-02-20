package com.project.Service.QuestionServices;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ViewQuestionsTest {

        ViewQuestions viewQuestions=new ViewQuestions();

    @Test
    void display() {
        assertEquals(true,viewQuestions.display());
    }
}