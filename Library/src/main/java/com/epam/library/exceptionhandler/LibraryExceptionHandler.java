package com.epam.library.exceptionhandler;

import com.epam.library.exception.BookAlreadyIssuedException;
import com.epam.library.exception.BookNotIssuedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class LibraryExceptionHandler {

    @ExceptionHandler(value = BookAlreadyIssuedException.class)
    public ResponseEntity<String> handleBookAlreadyIssuedException(){
        return new ResponseEntity<>("This book has already been issued", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = BookNotIssuedException.class)
    public ResponseEntity<String> handleBookNotIssuedException(){
        return new ResponseEntity<>("This book has not been issued",HttpStatus.BAD_REQUEST);
    }
}
