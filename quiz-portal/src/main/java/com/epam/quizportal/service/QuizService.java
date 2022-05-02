package com.epam.quizportal.service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import com.epam.quizportal.Exception.QuestionNotFoundException;
import com.epam.quizportal.Exception.QuizNotFoundException;
import com.epam.quizportal.dao.QuestionRepository;
import com.epam.quizportal.dao.QuizRepository;
import com.epam.quizportal.dto.QuestionDTO;
import com.epam.quizportal.dto.QuizDTO;
import com.google.common.reflect.TypeToken;
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

    @Autowired
    Random random;



    public QuizDTO viewQuiz(Integer code){
        Optional<Quiz> quiz=quizRepository.findById(code);
        if(quiz.isEmpty()){
            throw new QuizNotFoundException();
        }
        QuizDTO quizQuestions=modelMapper.map(quiz.get(),QuizDTO.class);
        return quizQuestions;
    }

    public QuizDTO createQuiz(List<Integer> questionIdList){
        Integer uniqueKey=findCodeExistence();
        Type listType=new TypeToken<List<QuestionDTO>>(){}.getType();
        List<QuestionDTO> questionDTOList=modelMapper.map(questionRepository.findAllById(questionIdList),listType);
        QuizDTO quizDto=new QuizDTO();
        quizDto.setCode(uniqueKey);
        quizDto.setQuestionsList(questionDTOList);
        Quiz quiz= quizRepository.save(modelMapper.map(quizDto,Quiz.class));
        return modelMapper.map(quiz,QuizDTO.class);

    }

    public Integer findCodeExistence(){
        int uniqueKey = random.nextInt(1000);
        Optional<Quiz> quizExistence=quizRepository.findById(uniqueKey);
        if(quizExistence.isPresent()){
            findCodeExistence();
        }
        return uniqueKey;
    }

    public QuizDTO addQuestionToQuiz(Integer code, Integer questionToBeAdded){
        Optional<Quiz> optionalQuiz=quizRepository.findById(code);
        if(optionalQuiz.isEmpty()){
            throw new QuizNotFoundException();
        }
        Optional<Questions> optionalQuestions=questionRepository.findById(questionToBeAdded);
        if(optionalQuestions.isEmpty()){
            throw new QuestionNotFoundException();
        }
        QuizDTO quiz=modelMapper.map(optionalQuiz.get(),QuizDTO.class);
        QuestionDTO question=modelMapper.map(optionalQuestions.get(),QuestionDTO.class);
        quiz.getQuestionsList().add(question);
        return modelMapper.map(quizRepository.save(modelMapper.map(quiz,Quiz.class)),QuizDTO.class);

    }

    public QuizDTO deleteQuestionFromQuiz(Integer code,Integer questionToBeDeleted){
        Optional<Quiz> optionalQuiz=quizRepository.findById(code);
        if(optionalQuiz.isEmpty()){
            throw new QuizNotFoundException();
        }
        Quiz quiz=optionalQuiz.get();
        Questions question=questionRepository.getById(questionToBeDeleted);
        quiz.getQuestionsList().remove(question);
        Quiz quizEntity=quizRepository.save(modelMapper.map(quiz,Quiz.class));
        return modelMapper.map(quizEntity,QuizDTO.class);
    }
}
