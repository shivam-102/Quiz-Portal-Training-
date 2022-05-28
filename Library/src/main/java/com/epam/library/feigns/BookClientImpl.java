package com.epam.library.feigns;

import com.epam.library.DTO.BookDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class BookClientImpl implements BookClient{
    @Override
    public ResponseEntity<List<BookDTO>> getBooks() {
        return new ResponseEntity<>(Arrays.asList(new BookDTO(0,"","","")), HttpStatus.OK);
    }

    @Override
    public BookDTO getBookById(Integer bookId) {
        return new BookDTO(0,"","","");
    }

    @Override
    public ResponseEntity<BookDTO> addBook(BookDTO bookDTO) {
        return new ResponseEntity<>(new BookDTO(0,"","",""),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BookDTO> updateBook(Integer id, BookDTO bookDTO) {
        return new ResponseEntity<>(new BookDTO(0,"","",""),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteBook(Integer id) {
        return new ResponseEntity<>("",HttpStatus.NO_CONTENT);
    }
}
