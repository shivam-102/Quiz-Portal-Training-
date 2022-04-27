package com.epam.quizportal.service;

import com.epam.quizportal.dao.QuestionRepository;
import com.epam.quizportal.dto.OptionsDTO;
import com.epam.quizportal.dto.QuestionDTO;
import com.epam.quizportal.entity.Options;
import com.epam.quizportal.entity.Questions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class QuestionServiceTest {

    @Mock
    QuestionRepository questionRepository;

    @Mock
    ModelMapper modelMapper;

    @InjectMocks
    QuestionService questionService;

    QuestionDTO questionDTO;

    Questions questions;

    List<Options> optionsList;

    List<OptionsDTO> optionsDTOS;

    List<Questions> questionsList;

    @BeforeEach
    void setUp(){
        questionDTO = new QuestionDTO();
        questionDTO.setQuestionId(1);
        questionDTO.setDifficulty("Easy");
        questionDTO.setQuestion("What is JAVA");
        questionDTO.setMarks(2);

        questions = new Questions();
        questions.setQuestionId(1);
        questions.setDifficulty("Easy");
        questions.setQuestion("What is JAVA");
        questions.setMarks(2);
        optionsList = new ArrayList<>();
        optionsDTOS = new ArrayList<>();
        questionsList=new ArrayList<>();
        optionsList.addAll(List.of(new Options(1, "Island", false)
                , new Options(1, "Coffee", true)));
        questions.setOption(optionsList);
        questionsList.add(questions);
        optionsDTOS.addAll(List.of(new OptionsDTO(1, "Island", false)
                , new OptionsDTO(1, "Coffee", true)));
        questionDTO.setOption(optionsDTOS);
    }
    @Test
    void viewQuestions() {

        when(questionRepository.findAll()).thenReturn(questionsList);
        assertThat(questionService.viewQuestions()).isEqualTo(questionsList);
        verify(questionRepository).findAll();

    }

    @Test
    void insertQuestion() {
        when(questionRepository.save(questions)).thenReturn(questions);
        when(modelMapper.map(questionDTO, Questions.class)).thenReturn(questions);
        when(modelMapper.map(questions, QuestionDTO.class)).thenReturn(questionDTO);
        assertThat(questionService.insertQuestion(questionDTO)).isEqualTo(questionDTO);
        verify(questionRepository).save(questions);
    }

    @Test
    void deleteQuestion() {
       when(questionRepository.findById(1)).thenReturn(Optional.ofNullable(questions));
       assertThat(questionService.deleteQuestion(1)).isEqualTo(true);
       verify(questionRepository,times(1)).deleteById(1);


    }

    @Test
    void modifyQuestion() {
        when(questionRepository.save(questions)).thenReturn(questions);
        when(questionRepository.findById(1)).thenReturn(Optional.ofNullable(questions));
        when(modelMapper.map(questionDTO, Questions.class)).thenReturn(questions);
        when(modelMapper.map(questions, QuestionDTO.class)).thenReturn(questionDTO);
        questions.setQuestion("new Question");
        assertThat(questionService.modifyQuestion(1,"new Question")).isEqualTo(true);
        verify(questionRepository).save(questions);


    }

    @Test
    void modifyDifficulty() {
        when(questionRepository.save(questions)).thenReturn(questions);
        when(questionRepository.findById(1)).thenReturn(Optional.ofNullable(questions));
        when(modelMapper.map(questionDTO, Questions.class)).thenReturn(questions);
        when(modelMapper.map(questions, QuestionDTO.class)).thenReturn(questionDTO);
        questions.setDifficulty("hard");
        assertThat(questionService.modifyDifficulty(1,"hard")).isEqualTo(true);
        verify(questionRepository).save(questions);
    }

    @Test
    void modifyMarks() {
        when(questionRepository.save(questions)).thenReturn(questions);
        when(questionRepository.findById(1)).thenReturn(Optional.ofNullable(questions));
        when(modelMapper.map(questionDTO, Questions.class)).thenReturn(questions);
        when(modelMapper.map(questions, QuestionDTO.class)).thenReturn(questionDTO);
        questions.setMarks(2);
        assertThat(questionService.modifyMarks(1,2)).isEqualTo(true);
        verify(questionRepository).save(questions);
    }

    @Test
    void modifyOptions() {
        when(questionRepository.save(questions)).thenReturn(questions);
        when(questionRepository.findById(1)).thenReturn(Optional.ofNullable(questions));
        when(modelMapper.map(questionDTO, Questions.class)).thenReturn(questions);
        when(modelMapper.map(questions, QuestionDTO.class)).thenReturn(questionDTO);
        questions.setOption(optionsList);
        assertThat(questionService.modifyOptions(1,optionsDTOS)).isEqualTo(true);
        verify(questionRepository).save(questions);
    }
}