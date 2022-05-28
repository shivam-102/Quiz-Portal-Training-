package com.epam.library.feigns;

import com.epam.library.DTO.BookDTO;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@FeignClient(name="book-service",fallback = BookClientImpl.class)
@LoadBalancerClient(name="book-service",configuration = BookClientImpl.class)
public interface BookClient {

    @GetMapping
    public ResponseEntity<List<BookDTO>> getBooks();

    @GetMapping("/{bookId}")
    public BookDTO getBookById(@PathVariable Integer bookId);

    @PostMapping
    public ResponseEntity<BookDTO> addBook(@RequestBody BookDTO bookDTO);

    @PutMapping("/{id}")
    public ResponseEntity<BookDTO> updateBook(@PathVariable Integer id,@RequestBody BookDTO bookDTO);

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Integer id);

}
