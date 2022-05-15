package com.epam.library.dao;

import com.epam.library.entity.LibraryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryDAO extends JpaRepository<LibraryEntity,Integer> {

    LibraryEntity findByUsernameAndBookId(String username,Integer bookId);

}
