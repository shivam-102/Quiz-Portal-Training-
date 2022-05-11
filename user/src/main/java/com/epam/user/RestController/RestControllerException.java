package com.epam.user.RestController;


import com.epam.user.Exception.UserDoesNotExistException;
import com.epam.user.Exception.UserExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestControllerException extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = UserDoesNotExistException.class)
    public ResponseEntity<String> handleUserDoesNotExistException(){
        return new ResponseEntity<String>("User does not exist. Please enter a valid username", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = UserExistsException.class)
    public ResponseEntity<String> handleUserExistsException(){
        return new ResponseEntity<String>("Username already taken. Please enter another username",HttpStatus.BAD_REQUEST);
    }
}
