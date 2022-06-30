package com.epam.quizportal.controller;

import com.epam.quizportal.dao.AuthGroupRepository;
import com.epam.quizportal.dto.QuestionDTO;
import com.epam.quizportal.util.JwtUtil;
import com.epam.quizportal.service.QuestionService;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import com.epam.quizportal.service.UserService;
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
import org.springframework.security.test.context.support.WithMockUser;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers =QuestionController.class)
@WithMockUser(username = "abc" , roles = {"ADMIN"})
class QuestionControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    QuestionService questionService;

    @MockBean
    AuthGroupRepository authGroupRepository;

    @MockBean
    UserService userService;

    @MockBean
    JwtUtil jwtUtil;

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
        when(questionService.deleteQuestion(2)).thenReturn("deleted");
        mockMvc.perform(post("/removeQuestion")).andExpect(view().name("success"));
    }

    @Test
    void getQuestionPage() throws Exception {
        mockMvc.perform(get("/getQuestion")).andExpect(status().isOk()).andExpect(view().name("getQuestionPage"));
    }

    @Test
    void getQuestion() throws Exception {
        when(questionService.viewQuestionById(2)).thenReturn(new QuestionDTO());
        mockMvc.perform(post("/fetchQuestionById")).andExpect(status().isOk()).andExpect(view().name("updateQuestionPage"));
    }

    @Test
    void updateQuestionPage() throws Exception {
        when(questionService.updateQuestion(new QuestionDTO())).thenReturn(new QuestionDTO());
        mockMvc.perform(post("/updateQuestion")).andExpect(status().isOk()).andExpect(view().name("success"));
    }

}