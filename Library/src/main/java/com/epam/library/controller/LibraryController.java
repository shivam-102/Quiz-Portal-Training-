package com.epam.library.controller;


import com.epam.library.DTO.LibraryDTO;
import com.epam.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/library")
public class LibraryController {

    @Autowired
    LibraryService libraryService;

    @PostMapping("/users/{username}/books/{bookId}")
    public ResponseEntity<LibraryDTO> issueBook(@PathVariable("username") String username, @PathVariable("bookId") Integer bookId , @RequestBody LibraryDTO libraryDTO){
        libraryDTO.setUsername(username);
        libraryDTO.setBookId(bookId);
        return new ResponseEntity<>(libraryService.issueBook(libraryDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/users/{username}/books/{bookId}")
    public ResponseEntity<String> deleteBook(@PathVariable("username") String username, @PathVariable("bookId") Integer bookId){
        libraryService.releaseBook(bookId,username);
        return new ResponseEntity<>("Book Released",HttpStatus.NO_CONTENT);
    }
}
