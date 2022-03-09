package com.project.dao;

import com.project.entity.Questions;
import com.project.entity.Quiz;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
class QuizDAOTest {
    @InjectMocks
    QuizDAO quizDAO;
    @Mock
    Questions questions;
    @Mock
    Quiz quiz;
    @Mock
    EntityManager entityManager;
    @Mock
    EntityTransaction entityTransaction;
    @Mock
    List<Questions> questionsList;
    @Mock
    Query query;
    @Mock
    List<Questions> questionsLi;
    @Test
    void getInstance() {
        QuizDAO quizDAO=new QuizDAO();
        assertNotNull(quizDAO.getInstance());
    }

    @Test
    void createQuiz() {
        List<Integer> list=new ArrayList<>();
        when(entityManager.createQuery("select quiz.id from Quiz quiz where quiz.id=:uniqueId")).thenReturn(query);
        when(query.setParameter("uniqueId",55)).thenReturn(query);
        when(query.getSingleResult()).thenReturn(null);
        when(entityManager.getTransaction()).thenReturn(entityTransaction);
        when(entityManager.createQuery("select questions from Questions questions WHERE question_id IN :ids")).thenReturn(query);
        when(query.setParameter("ids",list)).thenReturn(query);
        when(query.getResultList()).thenReturn(questionsLi);
        //quizDAO.createQuiz(entityManager,list);

    }

    @Test
    void findCodeExistance() {
    }

    @Test
    void addQuestion() {
        when(entityManager.getTransaction()).thenReturn(entityTransaction);
        int code=123;
        int index=1;
        Quiz quiz=new Quiz();
        quiz.setQuestionsList(questionsList);
        Questions questions=new Questions();
        when(entityManager.find(Quiz.class,code)).thenReturn(quiz);
        when(entityManager.find(Questions.class,index)).thenReturn(questions);
        quizDAO.addQuestion(entityManager,code,index);
        verify(entityManager).persist(any(Quiz.class));
        verify(entityTransaction).begin();
        verify(entityTransaction).commit();
    }

    @Test
    void deleteQuestion() {
        when(entityManager.getTransaction()).thenReturn(entityTransaction);
        int code=123;
        int index=1;
        Quiz quiz=new Quiz();
        quiz.setQuestionsList(questionsList);
        Questions questions=new Questions();
        when(entityManager.find(Quiz.class,code)).thenReturn(quiz);
        when(entityManager.find(Questions.class,index)).thenReturn(questions);
        quizDAO.deleteQuestion(entityManager,code,index);
        verify(entityManager).persist(any(Quiz.class));
        verify(entityTransaction).begin();
        verify(entityTransaction).commit();

    }
}