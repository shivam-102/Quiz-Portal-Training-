package com.project.service.questionservices;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class DeleteQuestionTest {
    DeleteQuestion deleteQuestion = new DeleteQuestion();
    @Test
    void deleteOperation() {
        assertEquals(true, deleteQuestion.deleteOperation(2));

    }
}