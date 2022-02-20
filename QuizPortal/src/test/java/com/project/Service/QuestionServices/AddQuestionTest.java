package com.project.Service.QuestionServices;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class AddQuestionTest {
    AddQuestion addQuestion=new AddQuestion();
    @Test
    void addQuestion() {
        assertEquals(true,addQuestion.addQuestion("Who are you?",new String[]{"a","b","c","d"},"easy","a"));
    }
}