package com.epam.quizportal.RestController;

import com.epam.quizportal.TestClass;
import com.epam.quizportal.dto.OptionsDTO;
import com.epam.quizportal.dto.QuestionDTO;
import com.epam.quizportal.entity.Options;
import com.epam.quizportal.entity.Questions;
import com.epam.quizportal.service.QuestionService;
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
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc(addFilters = false)
@SpringBootTest
class QuestionRestControllerTest extends TestClass {

    @Autowired
    MockMvc mockMvc;
    @MockBean
    QuestionService questionService;



    QuestionDTO questionDTO;

    Questions questions;

    List<Options> optionsList;

    List<OptionsDTO> optionsDTOS;

    List<Questions> questionsList;

    List<QuestionDTO> questionDTOList;

    @BeforeEach
    public void setUp(){

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
        questionDTOList=new ArrayList<>();
        optionsList.addAll(List.of(new Options(1, "Island", false)
                , new Options(1, "Coffee", true)));
        questions.setOption(optionsList);
        questionsList.add(questions);
        optionsDTOS.addAll(List.of(new OptionsDTO(1, "Island", false)
                , new OptionsDTO(1, "Coffee", true)));
        questionDTO.setOption(optionsDTOS);

        questionDTOList.add(questionDTO);


    }

    @Test
    void fetchQuestions() throws Exception {
        when(questionService.viewQuestions()).thenReturn(questionDTOList);
        String jsonExpression=new ObjectMapper().writeValueAsString(questionDTOList);
        mockMvc.perform(get("/questions").contentType(MediaType.APPLICATION_JSON).content(jsonExpression)).andExpect(status().isOk());

    }

    @Test
    void addQuestion() throws Exception {
        when(questionService.insertQuestion(questionDTO)).thenReturn(questionDTO);
        String jsonExpression=new ObjectMapper().writeValueAsString(questionDTO);
        mockMvc.perform(post("/questions").contentType(MediaType.APPLICATION_JSON).content(jsonExpression)).andExpect(status().isCreated());
    }

    @Test
    void deleteQuestion() throws Exception {
        when(questionService.deleteQuestion(questionDTO.getQuestionId())).thenReturn("deleted");
        String jsonExpression=new ObjectMapper().writeValueAsString(questionDTO);
        mockMvc.perform(delete("/questions/1").contentType(MediaType.APPLICATION_JSON).content(jsonExpression)).andExpect(MockMvcResultMatchers.status().isNoContent()).andDo(MockMvcResultHandlers.print());


    }

    @Test
    void updateQuestion() throws Exception {
        when(questionService.updateQuestion(questionDTO)).thenReturn(questionDTO);
        String jsonExpression=new ObjectMapper().writeValueAsString(questionDTO);
        mockMvc.perform(put("/questions").contentType(MediaType.APPLICATION_JSON).content(jsonExpression)).andExpect(status().isOk());


    }
}