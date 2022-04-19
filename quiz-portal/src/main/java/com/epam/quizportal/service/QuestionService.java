package com.epam.quizportal.service;

import com.epam.quizportal.dao.QuestionRepository;
import com.epam.quizportal.dto.OptionsDTO;
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


    public List<Questions> viewQuestions(){
        return questionRepository.findAll();
    }

    public QuestionDTO insertQuestion(QuestionDTO questionDTO){
        Questions newQuestion=questionRepository.save(modelMapper.map(questionDTO,Questions.class));
        return modelMapper.map(newQuestion,QuestionDTO.class);
    }

    public boolean deleteQuestion(Integer questionId){
        Optional<Questions> optionalQuestions=questionRepository.findById(questionId);
        boolean status=false;
        if(optionalQuestions.isPresent()){
            questionRepository.deleteById(questionId);
            status=true;
        }
        return status;

    }

    public boolean modifyQuestion(Integer questionNumber,String newQuestion){
        Optional<Questions> optionalQuestions=questionRepository.findById(questionNumber);
        boolean status=false;
        if(optionalQuestions.isPresent()){
            QuestionDTO questions=modelMapper.map(optionalQuestions.get(),QuestionDTO.class);
            questions.setQuestion(newQuestion);
            questionRepository.save(modelMapper.map(questions,Questions.class));
            status=true;

        }
        return status;
    }

    public boolean modifyDifficulty(Integer questionNumber,String newDifficulty){
        Optional<Questions> optionalQuestions=questionRepository.findById(questionNumber);
        boolean status=false;
        if(optionalQuestions.isPresent()){
            QuestionDTO questions=modelMapper.map(optionalQuestions.get(),QuestionDTO.class);
            questions.setDifficulty(newDifficulty);
            questionRepository.save(modelMapper.map(questions,Questions.class));
           status=true;

        }
        return status;
    }
    public Boolean modifyMarks(Integer questionNumber,Integer newMarks){
        Optional<Questions> optionalQuestions=questionRepository.findById(questionNumber);
        boolean status=false;
        if(optionalQuestions.isPresent()){
            QuestionDTO questions=modelMapper.map(optionalQuestions.get(),QuestionDTO.class);
            questions.setMarks(newMarks);
            questionRepository.save(modelMapper.map(questions,Questions.class));
            status=true;

        }
        return status;
    }

    public Boolean modifyOptions(Integer questionNumber, List<OptionsDTO> newOptions){
        Optional<Questions> optionalQuestions=questionRepository.findById(questionNumber);
        boolean status=false;
        if(optionalQuestions.isPresent()){
            QuestionDTO questions=modelMapper.map(optionalQuestions.get(),QuestionDTO.class);
            questions.setOption(newOptions);
            questionRepository.save(modelMapper.map(questions,Questions.class));
            status=true;

        }
        return status;
    }

}
