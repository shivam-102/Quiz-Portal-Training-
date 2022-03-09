package com.project.dao;
import com.project.entity.Options;
import com.project.entity.Questions;
import org.jetbrains.annotations.NotNull;
import javax.persistence.EntityManager;
import java.util.List;
public class QuestionDAO {
    public static QuestionDAO questionDAOInstance=null;
    public static QuestionDAO getInstance(){
        if(questionDAOInstance==null){
            return new QuestionDAO();
        }
        return questionDAOInstance;
    }

    public boolean insert(EntityManager entityManager, Questions questions){
        entityManager.getTransaction().begin();
        entityManager.persist(questions);
        entityManager.getTransaction().commit();
        return true;
    }

    public boolean delete(EntityManager entityManager,Questions questions){
        if(questions!=null){
            entityManager.getTransaction().begin();
            entityManager.remove(questions);
            entityManager.getTransaction().commit();
            return true;
        }
        else{
            return false;
        }
    }

    public boolean modifyQuestion(EntityManager entityManager,String newQuestion,Questions questions){
        entityManager.getTransaction().begin();
        questions.setQuestion(newQuestion);
        entityManager.persist(questions);
        entityManager.getTransaction().commit();
        return true;}

    public boolean modifyDifficulty(EntityManager entityManager,String newDifficulty,Questions questions){
        entityManager.getTransaction().begin();
        questions.setDifficulty(newDifficulty);
        entityManager.persist(questions);
        entityManager.getTransaction().commit();
        return true;
    }
    public boolean modifyOptions(EntityManager entityManager, List<Options> newOptions, @NotNull Questions questions){
        entityManager.getTransaction().begin();
        questions.setOption(newOptions);
        entityManager.persist(questions);
        entityManager.getTransaction().commit();
        return true;
    }
}
