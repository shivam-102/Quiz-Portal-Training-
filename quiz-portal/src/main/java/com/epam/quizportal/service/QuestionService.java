package com.epam.quizportal.service;

import com.epam.quizportal.dao.QuestionRepository;
import com.epam.quizportal.entity.Options;
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

}
