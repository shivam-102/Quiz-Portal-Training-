package com.epam.library.service;

import com.epam.library.dao.LibraryDAO;
import com.epam.library.DTO.LibraryDTO;
import com.epam.library.entity.LibraryEntity;
import com.epam.library.exception.BookAlreadyIssuedException;
import com.epam.library.exception.BookNotIssuedException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LibraryService {
    @Autowired
    LibraryDAO libraryDAO;

    @Autowired
    ModelMapper modelMapper;

    public LibraryDTO issueBook(LibraryDTO libraryDTO){
       Optional<LibraryEntity> optional= Optional.ofNullable(libraryDAO.findByUsernameAndBookId(libraryDTO.getUsername(), libraryDTO.getBookId()));
       if(optional.isPresent()){
           throw new BookAlreadyIssuedException();
       }
       LibraryEntity libraryEntity=modelMapper.map(libraryDTO,LibraryEntity.class);
       return modelMapper.map(libraryDAO.save(libraryEntity),LibraryDTO.class);

    }

    public void releaseBook(Integer bookId, String username){
        Optional<LibraryEntity> optional=Optional.ofNullable(libraryDAO.findByUsernameAndBookId(username,bookId));
        LibraryEntity library=optional.orElseThrow( () -> new BookNotIssuedException());
        libraryDAO.delete(library);

    }
}
