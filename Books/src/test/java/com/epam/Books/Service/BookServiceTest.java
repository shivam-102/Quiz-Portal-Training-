package com.epam.Books.Service;

import com.epam.Books.DAO.BookRepository;
import com.epam.Books.DTO.BookDTO;
import com.epam.Books.Entity.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @Mock
    BookRepository bookRepository;

    @Mock
    ModelMapper modelMapper;

    @InjectMocks
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
    void getBookById() {
        when(bookRepository.findById(1)).thenReturn(Optional.ofNullable(book));
        when(modelMapper.map(book,BookDTO.class)).thenReturn(bookDTO);
        assertThat(bookService.getBookById(1)).isEqualTo(bookDTO);
        verify(bookRepository).findById(1);

    }

    @Test
    void getAllBooks() {
        when(bookRepository.findAll()).thenReturn(bookList);
        when(bookService.getAllBooks()).thenReturn(bookDTOList);
        assertThat(bookService.getAllBooks()).isEqualTo(bookDTOList);
        verify(bookRepository,times(2)).findAll();

    }

    @Test
    void addBook() {
        when(bookRepository.save(book)).thenReturn(book);
        when(modelMapper.map(bookDTO,Book.class)).thenReturn(book);
        when(modelMapper.map(book,BookDTO.class)).thenReturn(bookDTO);
        assertThat(bookService.addBook(bookDTO)).isEqualTo(bookDTO);
        verify(bookRepository).save(book);
    }

    @Test
    void delete() {
        when(bookRepository.findById(1)).thenReturn(Optional.ofNullable(book));
        when(modelMapper.map(book,BookDTO.class)).thenReturn(bookDTO);
        assertThat(bookService.delete(1)).isEqualTo(bookDTO);
        verify(bookRepository,times(1)).delete(book);

    }

    @Test
    void updateBook() {
        when(bookRepository.findById(1)).thenReturn(Optional.ofNullable(book));
        when(bookService.updateBook(1,bookDTO)).thenReturn(bookDTO);
        assertThat(bookService.updateBook(1,bookDTO)).isEqualTo(bookDTO);
        verify(bookRepository,times(2)).save(book);

    }
}