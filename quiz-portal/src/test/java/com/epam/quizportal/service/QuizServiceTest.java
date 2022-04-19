package com.epam.quizportal.service;

import com.epam.quizportal.dao.QuestionRepository;
import com.epam.quizportal.dao.QuizRepository;
import com.epam.quizportal.dto.QuestionDTO;
import com.epam.quizportal.dto.QuizDTO;
import com.epam.quizportal.entity.Questions;
import com.epam.quizportal.entity.Quiz;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class QuizServiceTest {

    @Mock
    QuizRepository quizRepository;

    @Mock
    QuestionRepository questionRepository;

    @Mock
    ModelMapper modelMapper;

    //Random randomMock;

    @InjectMocks
    QuizService quizService;

    Quiz quiz;

    QuizDTO quizDTO;

    List<Questions> questionsList;

    List<Questions> questionDTOList;

    List<Integer> questionIdList;

    Questions questions;
    @BeforeEach
    void setUp(){
        quiz=new Quiz();
        quiz.setCode(102);
        questionsList=new ArrayList<>();
        questionsList.addAll(List.of(new Questions(1,"Favorite Song?","easy",2),new Questions(2,"Thor:4?","medium",1)));
        quiz.setQuestionsList(questionsList);

        quizDTO=new QuizDTO();
        quizDTO.setCode(102);
        questionDTOList=new ArrayList<>();
        questionDTOList.addAll(List.of(new Questions(1,"Favorite Song?","easy",2),new Questions(2,"Thor:4?","medium",1)));;
        quizDTO.setQuestionsList(questionDTOList);

        questionIdList=new ArrayList<>();
        questionIdList.add(1);
        questionIdList.add(2);

        questions = new Questions();
        questions.setQuestionId(1);
        questions.setDifficulty("Easy");
        questions.setQuestion("What is JAVA");
        questions.setMarks(2);
    }

    @Test
    void viewQuiz() {
       when(quizRepository.findById(102)).thenReturn(Optional.ofNullable(quiz));
       assertThat(quizService.viewQuiz(102)).isEqualTo(null);
       verify(quizRepository).findById(102);
    }

    @Test
    void createQuiz() {
       when(quizRepository.findById(anyInt())).thenReturn(Optional.empty());
        when(questionRepository.findAllById(questionIdList)).thenReturn(questionsList);
        assertThat(quizService.createQuiz(questionIdList)).isEqualTo(true);
        verify(quizRepository).save(any(Quiz.class));


    }

    @Test
    void findCodeExistence() {
        when(quizRepository.findById(anyInt())).thenReturn(Optional.empty());
        assertThat(quizService.findCodeExistence()).isInstanceOf(Integer.class);
    }

    @Test
    void addQuestionToQuiz() {
        when(modelMapper.map(quizDTO, Quiz.class)).thenReturn(quiz);
        when(modelMapper.map(quiz, QuizDTO.class)).thenReturn(quizDTO);
        when(quizRepository.getById(102)).thenReturn(quiz);
        when(questionRepository.getById(1)).thenReturn(questions);
        assertThat(quizService.addQuestionToQuiz(102,1)).isEqualTo(true);
        verify(quizRepository).save(quiz);

    }

    @Test
    void deleteQuestionFromQuiz() {

        when(modelMapper.map(quizDTO, Quiz.class)).thenReturn(quiz);
        when(modelMapper.map(quiz, QuizDTO.class)).thenReturn(quizDTO);
        when(quizRepository.getById(102)).thenReturn(quiz);
        when(questionRepository.getById(1)).thenReturn(questions);
        assertThat(quizService.deleteQuestionFromQuiz(102,1)).isEqualTo(true);
        verify(quizRepository).save(quiz);
    }
}