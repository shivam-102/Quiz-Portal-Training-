package com.project.service.questionservices;

import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ViewQuestionAvailableTest {
    EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("Quiz-Portal");
    EntityManager entityManager=entityManagerFactory.createEntityManager();
    @Test
    void perform() {
        ViewQuestionAvailable viewQuestionAvailable=mock(ViewQuestionAvailable.class);
        viewQuestionAvailable.perform();
        verify(viewQuestionAvailable,times(1)).perform();
    }

    @Test
    void display() {

    }
}