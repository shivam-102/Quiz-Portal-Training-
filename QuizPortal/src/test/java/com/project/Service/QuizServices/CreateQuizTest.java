package com.project.Service.QuizServices;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreateQuizTest {
    CreateQuiz createQuiz=new CreateQuiz();
    @Test
    void addQuestions() {
        assertEquals(true,createQuiz.addQuestions());
    }
}