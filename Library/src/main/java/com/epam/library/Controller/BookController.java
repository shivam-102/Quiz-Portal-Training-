package com.epam.library.Controller;

import com.epam.library.DTO.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;


@RestController
@RequestMapping(value = "/library/books")
public class BookController {

    String BOOK_BASE_URL="http://localhost:9090/books/";

    HttpHeaders httpHeaders=new HttpHeaders();

    @Autowired
    RestTemplate restTemplate;

    @GetMapping()
    public String getBooks(){
        return restTemplate.exchange(BOOK_BASE_URL, HttpMethod.GET,null,String.class).getBody();
    }

    @GetMapping("/{bookId}")
    public String getBookById(@PathVariable Integer bookId){
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity=new HttpEntity<>(httpHeaders);
        return restTemplate.exchange(BOOK_BASE_URL+"{bookId}",HttpMethod.GET,entity,String.class,bookId).getBody();
    }

    @PostMapping()
    public ResponseEntity<BookDTO> addBook(@RequestBody BookDTO bookDTO) {
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity <BookDTO> entity = new HttpEntity<>(bookDTO,httpHeaders);
        return new ResponseEntity<BookDTO>(restTemplate.exchange(BOOK_BASE_URL, HttpMethod.POST, entity, BookDTO.class).getBody(), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookDTO> updateBook(@PathVariable Integer id,@RequestBody BookDTO bookDTO){
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<BookDTO> entity=new HttpEntity<>(bookDTO,httpHeaders);
        return new ResponseEntity<BookDTO>(restTemplate.exchange(BOOK_BASE_URL+id,HttpMethod.PUT,entity, BookDTO.class).getBody(),HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Integer id){
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<BookDTO> entity=new HttpEntity<>(httpHeaders);
        return new ResponseEntity<>(restTemplate.exchange(BOOK_BASE_URL+id,HttpMethod.DELETE,entity,String.class).getBody(),HttpStatus.NO_CONTENT);
    }


}
