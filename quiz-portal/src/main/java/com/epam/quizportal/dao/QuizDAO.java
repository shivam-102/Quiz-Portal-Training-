package com.epam.quizportal.dao;

import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Component;

import com.epam.quizportal.entity.Questions;
import com.epam.quizportal.entity.Quiz;

@Component
public class QuizDAO {
	/*
	Quiz quiz=new Quiz();
	
	
	Random random=new Random();
	
	public Quiz questionsInTheQuiz(int code){
		EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("Quiz-Portal");
	    EntityManager entityManager=entityManagerFactory.createEntityManager();
	    String query="from Quiz quiz where quiz.code=:code";
	    //String queryString="select quiz.questionsList from Quiz quiz where quiz.code=:code";
        Quiz questionsInThisCode=(Quiz) entityManager.createQuery(query).setParameter("code",code).getSingleResult();
        return questionsInThisCode;		
	}
	
	
	public int findCodeExistence(){
        int uniqueKey = random.nextInt(1000);
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("Quiz-Portal");
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        String query="select quiz.id from Quiz quiz where quiz.id=:uniqueId";
        List<Quiz> countCheck=entityManager.createQuery(query).setParameter("uniqueId",uniqueKey).getResultList();
        if(countCheck.size()>0){
            findCodeExistence();
        }
        return uniqueKey;
    }

	
	public boolean addQuestion(int code,int index){
		EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("Quiz-Portal");
	    EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Quiz quizToBeModified=entityManager.find(Quiz.class,code);
        Questions questions=entityManager.find(Questions.class,index);
        quizToBeModified.getQuestionsList().add(questions);
        entityManager.persist(quizToBeModified);
        entityManager.getTransaction().commit();
        return true;
    }

    public boolean deleteQuestion(int code,int index){
    	EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("Quiz-Portal");
	    EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Quiz quizToBeModified=entityManager.find(Quiz.class,code);
        Questions questions=entityManager.find(Questions.class,index);
        quizToBeModified.getQuestionsList().remove(questions);
        entityManager.persist(quizToBeModified);
        entityManager.getTransaction().commit();
        return true;
    }


	public boolean createQuiz(int uniqueCode, EntityManager entityManager, List<Integer> questionsList) {
		
		entityManager.getTransaction().begin();
        List<Questions> questionsToBeAdded;
        questionsToBeAdded= entityManager.createQuery("select questions from Questions questions WHERE questionId IN :ids").setParameter("ids", questionsList).getResultList();
        quiz.setCode(uniqueCode);
        quiz.setQuestionsList(questionsToBeAdded);
        entityManager.persist(quiz);
        entityManager.getTransaction().commit();
        return true;

	}

	 */
}
