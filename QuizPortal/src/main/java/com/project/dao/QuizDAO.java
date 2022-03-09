package com.project.dao;
import com.project.entity.Questions;
import com.project.entity.Quiz;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Random;
public class QuizDAO {
    Quiz quizUtility=new Quiz();
    private static QuizDAO quizDAOInstance = null;
    EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("Quiz-Portal");
    EntityManager entityManager=entityManagerFactory.createEntityManager();
    Random random=new Random();

    public static QuizDAO getInstance() {
        if (quizDAOInstance == null) {
            return new QuizDAO();
        }
        return quizDAOInstance;
    }
    public boolean createQuiz(int quizCode,EntityManager entityManager, List<Integer> toAdd){
        entityManager.getTransaction().begin();
        List<Questions> questionsToBeAdded;
        questionsToBeAdded= entityManager.createQuery("select questions from Questions questions WHERE questionId IN :ids").setParameter("ids", toAdd).getResultList();
        quizUtility.setCode(quizCode);
        quizUtility.setQuestionsList(questionsToBeAdded);
        entityManager.persist(quizUtility);
        entityManager.getTransaction().commit();
        return true;
    }
    public int findCodeExistance(){
        //int uniqueKey = random.nextInt(1000);
        int uniqueKey =55;
        String query="select quiz.id from Quiz quiz where quiz.id=:uniqueId";
        Quiz countCheck= (Quiz) entityManager.createQuery(query).setParameter("uniqueId",uniqueKey).getSingleResult();
        if(countCheck!=null){
            findCodeExistance();
        }

        return uniqueKey;
    }

    public boolean addQuestion(EntityManager entityManager,int code,int index){
        entityManager.getTransaction().begin();
        Quiz quizToBeModified=entityManager.find(Quiz.class,code);
        Questions questions=entityManager.find(Questions.class,index);
        quizToBeModified.getQuestionsList().add(questions);
        entityManager.persist(quizToBeModified);
        entityManager.getTransaction().commit();
        return true;
    }

    public boolean deleteQuestion(EntityManager entityManager,int code,int index){
        entityManager.getTransaction().begin();
        Quiz quizToBeModified=entityManager.find(Quiz.class,code);
        Questions questions=entityManager.find(Questions.class,index);
        quizToBeModified.getQuestionsList().remove(questions);
        entityManager.persist(quizToBeModified);
        entityManager.getTransaction().commit();
        return true;
    }
}


