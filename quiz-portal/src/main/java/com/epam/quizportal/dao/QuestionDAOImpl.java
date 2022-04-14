package com.epam.quizportal.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Component;

import com.epam.quizportal.entity.Options;
import com.epam.quizportal.entity.Questions;

@Component
public class QuestionDAOImpl  {

	public Questions insert(EntityManager entityManager, Questions questions) {
		entityManager.getTransaction().begin();
		entityManager.persist(questions);
		entityManager.getTransaction().commit();
		return questions;
	}

	public List<Questions> viewQuestion() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Quiz-Portal");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		List<Questions> questionsToDisplay = entityManager.createQuery(
				"select new com.epam.quizportal.entity.Questions(q.id,q.question,q.difficulty,q.marks) from Questions q",
				Questions.class).getResultList();
		return questionsToDisplay;
	}

	public boolean delete(EntityManager entityManager, int questionToBeDeleted) {
		Questions question = entityManager.find(Questions.class, questionToBeDeleted);
		if (question != null) {
			entityManager.getTransaction().begin();
			entityManager.remove(question);
			entityManager.getTransaction().commit();
			return true;
		} else {
			return false;
		}
	}

	public boolean modifyQuestion(EntityManager entityManager, String newQuestion, Integer questionNumber) {
		Questions question = entityManager.find(Questions.class, questionNumber);
		if (question != null) {
			entityManager.getTransaction().begin();
			question.setQuestion(newQuestion);
			entityManager.persist(question);
			entityManager.getTransaction().commit();
			return true;
		} else {
			return false;
		}
	}
	
	public boolean modifyDifficulty(EntityManager entityManager, String newDifficulty, Integer questionNumber) {
		Questions question = entityManager.find(Questions.class, questionNumber);
		if (question != null) {
			entityManager.getTransaction().begin();
			question.setDifficulty(newDifficulty);
			entityManager.persist(question);
			entityManager.getTransaction().commit();
			return true;
		} else {
			return false;
		}
	}
	
	public boolean modifyMarks(EntityManager entityManager, Integer newMarks, Integer questionNumber) {
		Questions question = entityManager.find(Questions.class, questionNumber);
		if (question != null) {
			entityManager.getTransaction().begin();
			question.setMarks(newMarks);
			entityManager.persist(question);
			entityManager.getTransaction().commit();
			return true;
		} else {
			return false;
		}
	}

	public boolean modifyOptions(EntityManager entityManager, List<Options> newOptions, Integer questionNumber) {
		Questions question = entityManager.find(Questions.class, questionNumber);
		if (question != null) {
			entityManager.getTransaction().begin();
			question.setOption(newOptions);
			entityManager.persist(question);
			entityManager.getTransaction().commit();
			return true;
		} else {
			return false;
		}
		
	}

}
