package com.epam.quizportal.controller;

import com.epam.quizportal.dao.AuthGroupRepository;
import com.epam.quizportal.dto.QuizDTO;
import com.epam.quizportal.entity.Quiz;
import com.epam.quizportal.util.JwtUtil;
import com.epam.quizportal.service.QuizService;
import com.epam.quizportal.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers =QuizController.class)
@WithMockUser(username = "abc" , roles = {"ADMIN"})
class QuizControllerTest {

    @MockBean
    QuizService quizService;

    @Autowired
    MockMvc mockMvc;

    @MockBean
    AuthGroupRepository authGroupRepository;

    @MockBean
    UserService userService;

    @MockBean
    JwtUtil jwtUtil;

    @Test
    void viewQuiz() {
        QuizController quizController=new QuizController();
        ModelAndView modelandview=quizController.viewQuiz();
        assertEquals("codeInsertPage",modelandview.getViewName());
    }

    @Test
    void viewQuizInsertCode() throws Exception {
        Quiz quiz=new Quiz();
        Integer code=102;
        quiz.setCode(code);
        mockMvc.perform(post("/questionsInTheQuiz")).andExpect(view().name("questionsInTheQuiz"));


    }

    @Test
    void createQuizPage() {
        QuizController quizController=new QuizController();
        ModelAndView modelandview=quizController.createQuizPage();
        assertEquals("createQuizPage",modelandview.getViewName());
    }

    @Test
    void createQuiz() throws Exception {
        List<Integer> questionList=new ArrayList<>();
        questionList.add(1);
        questionList.add(2);
        String questionids="1,2";
        when(quizService.createQuiz(questionList)).thenReturn(new QuizDTO());
        mockMvc.perform(post("/createnewquiz")).andExpect(view().name("successQuiz"));

//        String questionsids = "1,2";
//        List<Integer> questionList=new ArrayList<>();
//        questionList.add(1);
//        questionList.add(2);
//        when(quizService.createQuiz(questionList)).thenReturn(true);
//        mockMvc.perform(post("/createnewquiz")).andExpect(status().isOk()).andExpect(view().name("success"));
    }

    @Test
    void modificationAddQuestionPage() {
        QuizController quizController=new QuizController();
        ModelAndView modelandview=quizController.modificationAddQuestionPage();
        assertEquals("modifyAddPage",modelandview.getViewName());

    }

    @Test
    void modificationAddQuestion() throws Exception {
        when(quizService.addQuestionToQuiz(102,2)).thenReturn(new QuizDTO());
        mockMvc.perform(post("/addQuestionToQuiz")).andExpect(view().name("successQuiz"));
    }

    @Test
    void modificationDeleteQuestionPage() {
        QuizController quizController=new QuizController();
        ModelAndView modelandview=quizController.modificationDeleteQuestionPage();
        assertEquals("modifyDeletePage",modelandview.getViewName());
    }

    @Test
    void modificationDeleteQuestion() throws Exception {
        when(quizService.deleteQuestionFromQuiz(102,2)).thenReturn(new QuizDTO());
        mockMvc.perform(post("/deleteQuestionfromQuiz")).andExpect(view().name("successQuiz"));
    }

}