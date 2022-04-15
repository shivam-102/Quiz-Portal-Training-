package com.epam.quizportal.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.springframework.stereotype.Component;
import com.epam.quizportal.entity.User;

@Component
public class UserDAO {
	/*

	EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("Quiz-Portal");
    
    public User userCredentialVerification(String userName,String password) {
    	User result;
    	EntityManager entityManager=entityManagerFactory.createEntityManager();
    	String queryString="from User where username=:userName and password=:password";
    	Query query=entityManager.createQuery(queryString);
    	query.setParameter("userName", userName);
    	query.setParameter("password", password);
    	try {
    		result=(User) query.getSingleResult();
    		entityManager.close();
    	}catch(NoResultException exception) {
    		entityManager.close();
    		result=null;
    	}
    	return result;
    }
    
    public boolean addNewUser(User user) {
    	EntityManager entityManager=entityManagerFactory.createEntityManager();
    	String queryString="from User where username=:userName";
    	Query query=entityManager.createQuery(queryString);
    	query.setParameter("userName",user.getUsername());
    	try {
    		query.getSingleResult();
    		entityManager.close();
    		return false;
    	}catch(NoResultException exception) {
    		entityManager.getTransaction().begin();
    		entityManager.persist(user);
    		entityManager.getTransaction().commit();
    		entityManager.close();
    		return true;
    	}
    	
    }


}


	 */
}