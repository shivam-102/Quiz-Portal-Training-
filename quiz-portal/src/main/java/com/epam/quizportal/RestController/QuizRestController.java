package com.epam.quizportal.RestController;

import com.epam.quizportal.dto.QuizDTO;
import com.epam.quizportal.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/quizs")
public class QuizRestController {
    @Autowired
    QuizService quizService;

    @GetMapping("/{quiz-code}")
    public ResponseEntity<QuizDTO> fetchQuiz(@PathVariable("quiz-code") int code){
        return new ResponseEntity<QuizDTO>(quizService.viewQuiz(code),HttpStatus.OK);
    }

    @PostMapping("/{question-ids}")
    public ResponseEntity<QuizDTO> createNewQuiz(@PathVariable("question-ids")String questionIds){
       List<Integer> questionIdList= Stream.of(questionIds.split(","))
               .map(String::trim)
               .map(Integer::parseInt)
               .collect(Collectors.toList());
        return new ResponseEntity<QuizDTO>(quizService.createQuiz(questionIdList),HttpStatus.CREATED);
    }

    @PutMapping("/{quiz-code}/{question-number}")
    public ResponseEntity<QuizDTO> addQuestionToQuiz(@PathVariable("quiz-code")Integer code,@PathVariable("question-number")Integer questionNumber){
        return new ResponseEntity<QuizDTO>(quizService.addQuestionToQuiz(code, questionNumber),HttpStatus.ACCEPTED);
    }

    @PutMapping("/deletequestion/{quiz-code}/{question-number}")
    public ResponseEntity<QuizDTO> deleteQuestionFromQuiz(@PathVariable("quiz-code")int code,@PathVariable("question-number")Integer questionNumber){
        return new ResponseEntity<QuizDTO>(quizService.deleteQuestionFromQuiz(code,questionNumber),HttpStatus.ACCEPTED);
    }

}
