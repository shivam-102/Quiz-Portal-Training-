package com.epam.quizportal.service;

import com.epam.quizportal.Exception.QuestionNotFoundException;
import com.epam.quizportal.dao.QuestionRepository;
import com.epam.quizportal.dto.OptionsDTO;
import com.epam.quizportal.dto.QuestionDTO;
import com.epam.quizportal.entity.Options;
import com.epam.quizportal.entity.Questions;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuestionService {

    @Autowired
	ModelMapper modelMapper;

    @Autowired
    QuestionRepository questionRepository;


    public List<QuestionDTO> viewQuestions(){
        Type listType=new TypeToken<List<QuestionDTO>>(){}.getType();
        return modelMapper.map(questionRepository.findAll(),listType);

    }

    public QuestionDTO viewQuestionById(Integer id){
        Questions questions=questionRepository.findById(id).get();
        return modelMapper.map(questions,QuestionDTO.class);

    }

    public QuestionDTO insertQuestion(QuestionDTO questionDTO){
        Questions newQuestion=questionRepository.save(modelMapper.map(questionDTO,Questions.class));
        return modelMapper.map(newQuestion,QuestionDTO.class);
    }

    public String deleteQuestion(Integer questionId){
        Optional<Questions> optionalQuestions=questionRepository.findById(questionId);
        if(optionalQuestions.isEmpty()){
            throw new QuestionNotFoundException();
        }
        questionRepository.deleteById(questionId);
        return "Deleted";

    }

    public QuestionDTO updateQuestion(QuestionDTO questionDTO){

        Optional<Questions> questions=questionRepository.findById(questionDTO.getQuestionId());
        if(questions.isEmpty()){
            throw new QuestionNotFoundException();
        }
            Questions question=questions.get();
            question.setQuestion(questionDTO.getQuestion());
            question.setDifficulty(questionDTO.getDifficulty());
            question.setMarks(questionDTO.getMarks());
            Type listType=new TypeToken<List<OptionsDTO>>(){}.getType();
            question.setOption(modelMapper.map(questionDTO.getOption(),listType));
            //question.setOption(toListEntityOptions(questionDTO.getOption()));
            return modelMapper.map(questionRepository.save(question),QuestionDTO.class);

    }

}
