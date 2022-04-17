package com.epam.quizportal.controller;

import com.epam.quizportal.service.QuestionService;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@RunWith(SpringRunner.class)
//@AutoConfigureMockMvc
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
        mockMvc.perform(post("/addQuestion").param("question",anyString()).param("difficulty",anyString()).param("marks", String.valueOf(anyInt())).param("option", String.valueOf(anyList()))).andExpect(status().isOk()).andExpect(view().name("success"));
        verify(questionService,times(1)).insertQuestion(any());
    }

    @Test
    void deleteQuestionPage() {
    }

    @Test
    void deletingQuestion() {
    }

    @Test
    void modifyQuestionPage() {
    }

    @Test
    void modifyQuestion() {
    }

    @Test
    void modifyDifficultyPage() {
    }

    @Test
    void modifyDifficulty() {
    }

    @Test
    void modifyMarksPage() {
    }

    @Test
    void modifyMarks() {
    }

    @Test
    void modifyOptionsPage() {
    }

    @Test
    void modifyOptions() {
    }
}