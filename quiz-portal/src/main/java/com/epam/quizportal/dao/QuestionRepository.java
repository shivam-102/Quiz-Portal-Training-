package com.epam.quizportal.dao;

import com.epam.quizportal.entity.Questions;
import org.springframework.data.jpa.repository.JpaRepository;


public interface QuestionRepository extends JpaRepository<Questions,Integer> {
}
