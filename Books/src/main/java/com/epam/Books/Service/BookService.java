package com.epam.Books.Service;

import com.epam.Books.DAO.BookRepository;
import com.epam.Books.DTO.BookDTO;
import com.epam.Books.Entity.Book;
import com.epam.Books.Exception.BookNotFoundException;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    BookRepository bookRepository;

    public BookDTO getBookById(Integer id){
        Optional<Book> optionalBook=bookRepository.findById(id);
        Book book=optionalBook.orElseThrow( () -> new BookNotFoundException());
        return modelMapper.map(optionalBook.get(),BookDTO.class);
    }

    public List<BookDTO> getAllBooks(){
        Type listType=new TypeToken<List<BookDTO>>(){}.getType();
        return modelMapper.map(bookRepository.findAll(),listType);
        }

    public BookDTO addBook(BookDTO bookDTO){
        return modelMapper.map(bookRepository.save(modelMapper.map(bookDTO,Book.class)),BookDTO.class);
    }


    public BookDTO delete(Integer id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        Book book = optionalBook.orElseThrow( () -> new BookNotFoundException());
        bookRepository.delete(book);
        return modelMapper.map(book,BookDTO.class);

    }



    public BookDTO updateBook(Integer id,BookDTO bookDTO){
        Optional<Book> optionalBook=bookRepository.findById(id);
        Book book=optionalBook.orElseThrow( () -> new BookNotFoundException());
        book.setAuthor(bookDTO.getAuthor());
        book.setName(bookDTO.getName());
        book.setPublisher(bookDTO.getPublisher());
        return modelMapper.map(bookRepository.save(book),BookDTO.class);
    }

}

