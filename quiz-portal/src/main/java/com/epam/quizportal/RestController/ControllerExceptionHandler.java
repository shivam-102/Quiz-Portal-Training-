package com.epam.quizportal.RestController;

import com.epam.quizportal.Exception.QuestionNotFoundException;
import com.epam.quizportal.Exception.QuizNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = QuestionNotFoundException.class)
    public ResponseEntity<String> handleQuestionException(){
        return new ResponseEntity<String>("Question not found in the database.", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value= QuizNotFoundException.class)
    public ResponseEntity<String> handleQuizException(){
        return new ResponseEntity<String>("Quiz not found in the database",HttpStatus.BAD_REQUEST);
    }
}
