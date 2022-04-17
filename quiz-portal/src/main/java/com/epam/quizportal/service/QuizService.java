package com.epam.quizportal.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import com.epam.quizportal.dao.QuestionRepository;
import com.epam.quizportal.dao.QuizRepository;
import com.epam.quizportal.dto.QuizDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.quizportal.entity.Questions;
import com.epam.quizportal.entity.Quiz;

@Service
public class QuizService {

    @Autowired
    QuizRepository quizRepository;

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    ModelMapper modelMapper;

    Random random=new Random();


    public Quiz viewQuiz(Integer code){
        Optional<Quiz> quiz=quizRepository.findById(code);
        if(quiz.isPresent()){
            QuizDTO quizQuestions=modelMapper.map(quiz.get(),QuizDTO.class);
            return modelMapper.map(quizQuestions,Quiz.class);
        }

        return null;
    }
    public boolean createQuiz(List<Integer> questionIdList){
        Integer uniqueKey=findCodeExistence();
        QuizDTO quiz=new QuizDTO();
        quiz.setCode(uniqueKey);
        List<Questions> questionsList=questionRepository.findAllById(questionIdList);
        quiz.setQuestionsList(questionsList);
        quizRepository.save(modelMapper.map(quiz,Quiz.class));
        return false;
    }

    public Integer findCodeExistence(){
        int uniqueKey = random.nextInt(1000);
        Optional<Quiz> quizExistence=quizRepository.findById(uniqueKey);
        if(quizExistence.isPresent()){
            findCodeExistence();
        }
        return uniqueKey;
    }
    public void addQuestionToQuiz(Integer code, Integer questionToBeAdded){
        QuizDTO quiz=modelMapper.map(quizRepository.getById(code),QuizDTO.class);
        Questions question=questionRepository.getById(questionToBeAdded);
        quiz.getQuestionsList().add(question);
        quizRepository.save(modelMapper.map(quiz,Quiz.class));
    }

    public void deleteQuestionFromQuiz(Integer code,Integer questionToBeDeleted){
        QuizDTO quiz=modelMapper.map(quizRepository.getById(code),QuizDTO.class);
        Questions question=questionRepository.getById(questionToBeDeleted);
        quiz.getQuestionsList().remove(question);
        quizRepository.save(modelMapper.map(quiz,Quiz.class));
    }

}
