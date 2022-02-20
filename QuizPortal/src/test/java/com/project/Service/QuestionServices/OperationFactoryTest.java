package com.project.Service.QuestionServices;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OperationFactoryTest {
    @Test
    void getOperation(int i) {
        assertEquals(new ViewQuestions(),OperationFactory.getOperation(1));
        assertEquals(new AddQuestion(),OperationFactory.getOperation(2));
        assertEquals(new DeleteQuestion(),OperationFactory.getOperation(3));
        assertEquals(new ModifyQuestion(),OperationFactory.getOperation(4));

    }
}