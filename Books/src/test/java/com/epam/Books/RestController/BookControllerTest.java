package com.epam.Books.RestController;

import com.epam.Books.DTO.BookDTO;
import com.epam.Books.Entity.Book;
import com.epam.Books.Service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
class BookControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    BookService bookService;

    Book book;

    BookDTO bookDTO;

    List<Book> bookList;

    List<BookDTO> bookDTOList;



    @BeforeEach
    void setUp(){
        book=new Book();
        book.setId(1);
        book.setName("BookMock");
        book.setAuthor("Mock Author");
        book.setPublisher("Mock Publisher");


        bookDTO=new BookDTO();
        bookDTO.setId(1);
        bookDTO.setName("BookMock");
        bookDTO.setAuthor("Mock Author");
        bookDTO.setPublisher("Mock Publisher");

        bookList=new ArrayList<>();
        bookList.add(book);

        bookDTOList=new ArrayList<>();
        bookDTOList.add(bookDTO);

    }

    @Test
    void getAllBooks() throws Exception {
        when(bookService.getAllBooks()).thenReturn(bookDTOList);
        String jsonExpression=new ObjectMapper().writeValueAsString(bookDTOList);
        mockMvc.perform(get("/books").contentType(MediaType.APPLICATION_JSON).content(jsonExpression)).andExpect(status().isOk());


    }

    @Test
    void getBookById() throws Exception{
        when(bookService.getBookById(1)).thenReturn(bookDTO);
        String jsonExpression=new ObjectMapper().writeValueAsString(bookDTO);
        mockMvc.perform(get("/books/1").contentType(MediaType.APPLICATION_JSON).contentType(jsonExpression)).andExpect(status().isOk());
    }

    @Test
    void insertBook() throws Exception {
        when(bookService.addBook(bookDTO)).thenReturn(bookDTO);
        String jsonExpression=new ObjectMapper().writeValueAsString(bookDTO);
        mockMvc.perform(post("/books").contentType(MediaType.APPLICATION_JSON).content(jsonExpression)).andExpect(status().isCreated());
    }

    @Test
    void deleteBook() throws Exception {
        when(bookService.delete(1)).thenReturn(bookDTO);
        String jsonExpression=new ObjectMapper().writeValueAsString(bookDTO);
        mockMvc.perform(delete("/books/1").contentType(jsonExpression).content(jsonExpression)).andExpect(status().isNoContent()).andDo(print());




    }

    @Test
    void updateBook() throws Exception {
        when(bookService.updateBook(1,bookDTO)).thenReturn(bookDTO);
        String jsonExpression=new ObjectMapper().writeValueAsString(bookDTO);
        mockMvc.perform(put("/books/1").contentType(MediaType.APPLICATION_JSON).content(jsonExpression)).andExpect(status().isOk());

    }
}