package com.epam.quizportal.service;

import com.epam.quizportal.dao.QuestionRepository;
import com.epam.quizportal.entity.Options;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.epam.quizportal.dto.QuestionDTO;
import com.epam.quizportal.entity.Questions;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
	ModelMapper modelMapper;

    @Autowired
    QuestionRepository questionRepository;

    public QuestionDTO insertQuestion(QuestionDTO questionDTO){
        Questions newQuestion=questionRepository.save(modelMapper.map(questionDTO,Questions.class));
        return modelMapper.map(newQuestion,QuestionDTO.class);
    }

    public void deleteQuestion(Integer questionId){
        questionRepository.deleteById(questionId);

    }

    public Boolean modifyQuestion(Integer questionNumber,String newQuestion){
        Optional<Questions> optionalQuestions=questionRepository.findById(questionNumber);
        if(optionalQuestions.isPresent()){
            Questions questions=optionalQuestions.get();
            questions.setQuestion(newQuestion);
            questionRepository.save(questions);
            return true;

        }
        else{
            return false;
        }

    }

    public Boolean modifyDifficulty(Integer questionNumber,String newDifficulty){
        Optional<Questions> optionalQuestions=questionRepository.findById(questionNumber);
        if(optionalQuestions.isPresent()){
            Questions questions=optionalQuestions.get();
            questions.setDifficulty(newDifficulty);
            questionRepository.save(questions);
            return true;

        }
        else{
            return false;
        }

    }
    public Boolean modifyMarks(Integer questionNumber,Integer newMarks){
        Optional<Questions> optionalQuestions=questionRepository.findById(questionNumber);
        if(optionalQuestions.isPresent()){
            Questions questions=optionalQuestions.get();
            questions.setMarks(newMarks);
            questionRepository.save(questions);
            return true;

        }
        else{
            return false;
        }

    }

    public Boolean modifyOptions(Integer questionNumber, List<Options> newOptions){
        Optional<Questions> optionalQuestions=questionRepository.findById(questionNumber);
        if(optionalQuestions.isPresent()){
            Questions questions=optionalQuestions.get();
            questions.setOption(newOptions);
            questionRepository.save(questions);
            return true;

        }
        else{
            return false;
        }
    }


    /*
    EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("Quiz-Portal");
    EntityManager entityManager=entityManagerFactory.createEntityManager();



    public QuestionDTO insertQuestion(QuestionDTO questionDTO){
        Questions newQuestion=questionRepository.save(modelmapper.map(questionDTO,Questions.class));
        return modelmapper.map(newQuestion,QuestionDTO.class);

    }
    

    
    public List<Questions> viewQuestions() {
    	//return modelmapper.map(questionDAO.viewQuestion(), QuestionDTO.class);
    	
    	return questionDAOimpl.viewQuestion();
    }
    
    public boolean delete(Integer questionNumber) {
    	return questionDAOimpl.delete(entityManager, questionNumber);
    }
    
    public boolean modifyQuestionService(String newQuestion,Integer questionNumber) {
    	return questionDAOimpl.modifyQuestion(entityManager, newQuestion, questionNumber);
    }
    
    public boolean modifyDifficultyService(String newDifficulty,Integer questionNumber) {
    	return questionDAOimpl.modifyDifficulty(entityManager, newDifficulty, questionNumber);
    }
    
    public boolean modifyMarksService(Integer newMarks,Integer questionNumber) {
    	return questionDAOimpl.modifyMarks(entityManager, newMarks, questionNumber);
    }
    
    
    public boolean modifyOptionsService(List<Options> newOptions,Integer questionNumber) {
    	return questionDAOimpl.modifyOptions(entityManager, newOptions, questionNumber);
    }


     */
}
