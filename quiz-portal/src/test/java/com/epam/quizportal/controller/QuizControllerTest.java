package com.epam.quizportal.controller;

import com.epam.quizportal.entity.Quiz;
import com.epam.quizportal.service.QuizService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers =QuizController.class)
class QuizControllerTest {

    @MockBean
    QuizService quizService;

    @Autowired
    MockMvc mockMvc;

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
        when(quizService.viewQuiz(code)).thenReturn(quiz);
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
        when(quizService.addQuestionToQuiz(102,2)).thenReturn(true);
        mockMvc.perform(post("/addQuestionToQuiz")).andExpect(view().name("success"));
    }

    @Test
    void modificationDeleteQuestionPage() {
        QuizController quizController=new QuizController();
        ModelAndView modelandview=quizController.modificationDeleteQuestionPage();
        assertEquals("modifyDeletePage",modelandview.getViewName());
    }

    @Test
    void modificationDeleteQuestion() throws Exception {
        when(quizService.deleteQuestionFromQuiz(102,2)).thenReturn(true);
        mockMvc.perform(post("/deleteQuestionfromQuiz")).andExpect(view().name("success"));


    }
}