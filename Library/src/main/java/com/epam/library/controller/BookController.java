package com.epam.library.controller;

import com.epam.library.DTO.BookDTO;
import com.epam.library.feigns.BookClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping(value = "/library/books")
public class BookController {
    @Autowired
    BookClient bookClient;

    @GetMapping()
    public ResponseEntity<List<BookDTO>> getBooks(){
        return new ResponseEntity<>(bookClient.getBooks().getBody(),HttpStatus.OK);

    }

    @GetMapping("/{bookId}")
    public BookDTO getBookById(@PathVariable Integer bookId){
//        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
//        HttpEntity<String> entity=new HttpEntity<>(httpHeaders);
//        return restTemplate.exchange(BOOK_BASE_URL+"{bookId}",HttpMethod.GET,entity,String.class,bookId).getBody();
          return bookClient.getBookById(bookId).getBody();
    }

    @PostMapping()
    public ResponseEntity<BookDTO> addBook(@RequestBody BookDTO bookDTO) {
          return new ResponseEntity<>(bookClient.addBook(bookDTO).getBody(),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookDTO> updateBook(@PathVariable Integer id,@RequestBody BookDTO bookDTO){
          return new ResponseEntity<>(bookClient.updateBook(id, bookDTO).getBody(),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Integer id){
        bookClient.deleteBook(id);
        return new ResponseEntity<>("Deleted",HttpStatus.NO_CONTENT);
    }
}
