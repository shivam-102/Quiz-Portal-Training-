package com.epam.quizportal.RestController;


import com.epam.quizportal.dto.QuestionDTO;
import com.epam.quizportal.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionRestController {
    @Autowired
    QuestionService questionService;

    @GetMapping()
    public ResponseEntity<List<QuestionDTO>> fetchQuestions(){
        return new ResponseEntity<List<QuestionDTO>>(questionService.viewQuestions(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<QuestionDTO> addQuestion(@RequestBody QuestionDTO question){
        return new ResponseEntity<QuestionDTO>(questionService.insertQuestion(question), HttpStatus.CREATED);
    }

    @DeleteMapping("/{questionid}")
    public ResponseEntity<String> deleteQuestion(@PathVariable("questionid") Integer questionId){
        String response=questionService.deleteQuestion(questionId);
        return new ResponseEntity<String>(response,HttpStatus.NO_CONTENT);
    }

    @PutMapping()
    public ResponseEntity<QuestionDTO> updateQuestion(@RequestBody QuestionDTO questionDTO){
        return new ResponseEntity<QuestionDTO>(questionService.updateQuestion(questionDTO),HttpStatus.OK);
    }
}
