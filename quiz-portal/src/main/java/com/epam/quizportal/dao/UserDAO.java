package com.epam.quizportal.dao;

import com.epam.quizportal.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;


public interface UserDAO extends JpaRepository<User,String> {
    public User findByUsername(String username);
}
