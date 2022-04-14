package com.epam.quizportal.dao;

import com.epam.quizportal.entity.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface QuestionRepository extends JpaRepository<Questions,Integer> {
}
