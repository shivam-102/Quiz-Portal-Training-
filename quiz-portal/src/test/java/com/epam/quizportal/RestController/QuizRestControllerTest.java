package com.epam.quizportal.RestController;


import com.epam.quizportal.dto.QuestionDTO;
import com.epam.quizportal.dto.QuizDTO;
import com.epam.quizportal.entity.Questions;
import com.epam.quizportal.entity.Quiz;
import com.epam.quizportal.service.QuizService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc(addFilters = false)
@SpringBootTest
class QuizRestControllerTest {

    @Autowired
    MockMvc mockMvc;
    @MockBean
    QuizService quizService;


    Quiz quiz;

    QuizDTO quizDTO;

    List<Questions> questionsList;

    List<QuestionDTO> questionDTOList;

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
        questionDTOList.addAll(List.of(new QuestionDTO(1,"Favorite Song?","easy",2),new QuestionDTO(2,"Thor:4?","medium",1)));;
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
    void fetchQuiz() throws Exception {
        when(quizService.viewQuiz(102)).thenReturn(quizDTO);
        String jsonExpression=new ObjectMapper().writeValueAsString(quizDTO);
        mockMvc.perform(get("/quizs/{quiz-code}",102).contentType(MediaType.APPLICATION_JSON).content(jsonExpression)).andExpect(status().isOk());


    }

    @Test
    void createNewQuiz() throws Exception {
        when(quizService.createQuiz(questionIdList)).thenReturn(quizDTO);
        String jsonExpression=new ObjectMapper().writeValueAsString(quizDTO);
        mockMvc.perform(post("/quizs/{question-ids}","2").contentType(MediaType.APPLICATION_JSON).content(jsonExpression)).andExpect(status().isCreated());
    }


    @Test
    void addQuestionToQuiz() throws Exception {
        when(quizService.addQuestionToQuiz(102,2)).thenReturn(quizDTO);
        String jsonExpression=new ObjectMapper().writeValueAsString(quizDTO);
        mockMvc.perform(put("/quizs/{quiz-code}/{question-number}",102,2).contentType(MediaType.APPLICATION_JSON).content(jsonExpression)).andExpect(MockMvcResultMatchers.status().isAccepted());


    }

    @Test
    void updateQuestion() throws Exception {
          when(quizService.deleteQuestionFromQuiz(102,2)).thenReturn(quizDTO);
          String jsonExpression=new ObjectMapper().writeValueAsString(quizDTO);
          mockMvc.perform(put("/quizs/deletequestion/{quiz-code}/{question-number}",102,2).contentType(MediaType.APPLICATION_JSON).content(jsonExpression)).andExpect(status().isNoContent());


    }


}