package com.epam.Books.RestController;


import com.epam.Books.DTO.BookDTO;
import com.epam.Books.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping()
    public ResponseEntity<List<BookDTO>> getAllBooks(){
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable("id") Integer id){
        return new ResponseEntity<>(bookService.getBookById(id), HttpStatus.FOUND);
    }

    @PostMapping()
    public ResponseEntity<BookDTO> insertBook(@RequestBody BookDTO bookDTO){
        return new ResponseEntity<>(bookService.addBook(bookDTO),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable("id") Integer id){
        bookService.delete(id);
        return new ResponseEntity<>("Book Deleted Successfully",HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookDTO> updateBook(@PathVariable("id") Integer id, @RequestBody BookDTO bookDTO){
        return new ResponseEntity<>(bookService.updateBook(id,bookDTO),HttpStatus.ACCEPTED);
    }

}
