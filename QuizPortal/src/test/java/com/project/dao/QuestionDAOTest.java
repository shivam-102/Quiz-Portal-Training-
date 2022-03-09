package com.project.dao;

import com.project.entity.Options;
import com.project.entity.Questions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class QuestionDAOTest {

    @InjectMocks
    QuestionDAO questionDAO;
    @Mock
    Questions questions;
    @Mock
    private EntityTransaction entityTransaction;
    @Mock
    private EntityManager entityManager;
    @Mock
    List<Options> optionsList;
    @Test
    void insert() {
        when(entityManager.getTransaction()).thenReturn(entityTransaction);
        questionDAO.insert(entityManager,questions);
        verify(entityManager).persist(any(Questions.class));
        verify(entityTransaction).begin();
        verify(entityTransaction).commit();
    }
    @Test
    void delete() {
        when(entityManager.getTransaction()).thenReturn(entityTransaction);
        boolean b=questionDAO.delete(entityManager,questions);
        verify(entityTransaction).begin();
        verify(entityTransaction).commit();
        verify(entityManager).remove(any(Questions.class));
        assertEquals(true,b);

    }
    @Test
    void deleteForFalse(){
        //when(entityManager.getTransaction()).thenReturn(entityTransaction);
        boolean b=questionDAO.delete(entityManager,null);
        assertEquals(false,b);
    }

    @Test
    void modifyOptions(){
        when(entityManager.getTransaction()).thenReturn(entityTransaction);
        questionDAO.modifyOptions(entityManager,optionsList,questions);
        verify(entityManager).persist(any(Questions.class));
        verify(entityTransaction).begin();
        verify(entityTransaction).commit();
    }
    @Test
    void modifyDifficulty(){
        when(entityManager.getTransaction()).thenReturn(entityTransaction);
        String difficulty="Easy";
        questionDAO.modifyDifficulty(entityManager,difficulty,questions);
        verify(entityManager).persist(any(Questions.class));
        verify(entityTransaction).begin();
        verify(entityTransaction).commit();
    }
    @Test
    void getInstance(){
        QuestionDAO questionDAO=new QuestionDAO();
        assertNotNull(questionDAO.getInstance());
    }
    @Test
    void modifyQuestion(){
        when(entityManager.getTransaction()).thenReturn(entityTransaction);
        String question="New Question";
        questionDAO.modifyQuestion(entityManager,question,questions);
        verify(entityManager).persist(any(Questions.class));
        verify(entityTransaction).begin();
        verify(entityTransaction).commit();
    }
}