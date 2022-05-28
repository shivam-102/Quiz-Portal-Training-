package com.epam.Books.exceptions;

import com.epam.Books.Exception.BookNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BooksExceptionHandler {
    @ExceptionHandler(value = BookNotFoundException.class)
    public ResponseEntity<String> handleBookNotFoundException(){
        return new ResponseEntity<>("Book does not exist.", HttpStatus.BAD_REQUEST);
    }
}
