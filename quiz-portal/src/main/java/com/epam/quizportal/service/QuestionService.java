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
            question.setOption(toListEntityOptions(questionDTO.getOption()));
            return modelMapper.map(questionRepository.save(question),QuestionDTO.class);

    }






















    public boolean modifyQuestion(Integer questionNumber,String newQuestion){
        Optional<Questions> optionalQuestions=questionRepository.findById(questionNumber);
        if(optionalQuestions.isEmpty()){
            throw new QuestionNotFoundException();
        }
        QuestionDTO questions=modelMapper.map(optionalQuestions.get(),QuestionDTO.class);
        questions.setQuestion(newQuestion);
        questionRepository.save(modelMapper.map(questions,Questions.class));
        return true;

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

    public List<Options> toListEntityOptions(List<OptionsDTO> optionsDTOS){
        return optionsDTOS.stream().map(option -> modelMapper.map(option,Options.class)).collect(Collectors.toList());
    }

}
