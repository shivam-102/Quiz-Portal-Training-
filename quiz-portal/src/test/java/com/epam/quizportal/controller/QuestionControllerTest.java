package com.epam.quizportal.controller;

import com.epam.quizportal.dto.QuestionDTO;
import com.epam.quizportal.service.QuestionService;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.ModelAndView;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers =QuestionController.class)
class QuestionControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    QuestionService questionService;

    @Test
    void viewQuestion() throws Exception {
        mockMvc.perform(get("/viewAvailableQuestions")).andExpect(status().isOk()).andExpect(view().name("viewQuestions"));
    }

    @Test
    void openPage() throws Exception {
        mockMvc.perform(get("/addingQuestion")).andExpect(status().isOk()).andExpect(view().name("createQuestion"));
    }

    @Test
    void addingQuestion() throws Exception {
        QuestionDTO questionDTO=new QuestionDTO();
        questionDTO.setQuestion("questionTitle");
        questionDTO.setDifficulty("hard");
        questionDTO.setMarks(2);
        questionDTO.setQuestionId(1);
        when(questionService.insertQuestion(questionDTO)).thenReturn(questionDTO);
        mockMvc.perform(post("/addQuestion")).andExpect(view().name("success")).andExpect(status().isOk());
    }

    @Test
    void deleteQuestionPage() throws Exception {
        QuestionController questionController=new QuestionController();
        ModelAndView modelAndView=questionController.deleteQuestionPage();
        assertEquals("deleteQuestion",modelAndView.getViewName());
        mockMvc.perform(get("/deleteQuestion")).andExpect(status().isOk()).andExpect(view().name("deleteQuestion"));

    }

    @Test
    void deletingQuestion() throws Exception {
        int mockQuestionId=1;
        when(questionService.deleteQuestion(mockQuestionId)).thenReturn(true);
        mockMvc.perform(post("/modifyQuestion")).andExpect(view().name("modifyQuestionPage"));
    }

    @Test
    void questionModificationPage() throws Exception {
        mockMvc.perform(post("/removeQuestion")).andExpect(view().name("success"));
    }

    @Test
    void modifyQuestionPage() throws Exception {
        mockMvc.perform(get("/questionModification")).andExpect(status().isOk()).andExpect(view().name("questionModificationPage"));

    }

    @Test
    void modifyQuestion() throws Exception {
        when(questionService.modifyQuestion(1,"newQuestion")).thenReturn(true);
        mockMvc.perform(post("/modifyquestion")).andExpect(status().isOk()).andExpect(view().name("modifyQuestionPage"));
    }

    @Test
    void modifyDifficultyPage() throws Exception {
        mockMvc.perform(get("/modifyDifficulty")).andExpect(status().isOk()).andExpect(view().name("modifyDifficultyPage"));
    }

    @Test
    void modifyDifficulty() throws Exception {
        when(questionService.modifyDifficulty(1,"hard")).thenReturn(true);
        mockMvc.perform(post("/modifydifficulty")).andExpect(status().isOk()).andExpect(view().name("modifyDifficultyPage"));
    }

    @Test
    void modifyMarksPage() throws Exception {
        mockMvc.perform(get("/modifyMarks")).andExpect(status().isOk()).andExpect(view().name("modifyMarksPage"));
    }

    @Test
    void modifyMarks() throws Exception {
        when(questionService.modifyMarks(1,2)).thenReturn(true);
        mockMvc.perform(post("/modifymarks")).andExpect(status().isOk()).andExpect(view().name("modifyMarksPage"));
    }

    @Test
    void modifyOptionsPage() throws Exception {
        mockMvc.perform(get("/modifyOptions")).andExpect(status().isOk()).andExpect(view().name("modifyOptionsPage"));
    }

}