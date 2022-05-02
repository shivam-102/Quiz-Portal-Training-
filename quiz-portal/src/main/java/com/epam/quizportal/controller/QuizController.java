package com.epam.quizportal.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.epam.quizportal.service.QuizService;

@Controller
public class QuizController {

	@Autowired
	private QuizService quizservice;

	private static final String SUCCESS="success";

	@RequestMapping("/insertCode")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public ModelAndView viewQuiz(){
		ModelAndView modelandview=new ModelAndView();
		modelandview.setViewName("codeInsertPage");
		return modelandview;
	}

	@PostMapping(value="questionsInTheQuiz")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public ModelAndView viewQuizInsertCode(Integer code) {
		ModelAndView modelandview=new ModelAndView();
		modelandview.addObject("quiz",quizservice.viewQuiz(code));
		modelandview.setViewName("questionsInTheQuiz");
		return modelandview;
	}


	@RequestMapping("/createQuiz")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public ModelAndView createQuizPage() {
		ModelAndView modelandview=new ModelAndView();
		modelandview.setViewName("createQuizPage");
		return modelandview;
	}

	@PostMapping(value="createnewquiz")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public ModelAndView createQuiz(String questionsids) {
		ModelAndView modelandview= new ModelAndView();
		List<Integer> questionList = Stream.of(questionsids.split(","))
				  .map(String::trim)
				  .map(Integer::parseInt)
				  .collect(Collectors.toList());
		quizservice.createQuiz(questionList);
		modelandview.setViewName(SUCCESS);
		return modelandview;
	}

	@RequestMapping("/modificationAddOperation")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public ModelAndView modificationAddQuestionPage() {
		ModelAndView modelandview=new ModelAndView();
		modelandview.setViewName("modifyAddPage");
		return modelandview;
	}

	@PostMapping(value="addQuestionToQuiz")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public ModelAndView modificationAddQuestion(Integer code,Integer questionToAdd) {
		ModelAndView modelandview=new ModelAndView();
		quizservice.addQuestionToQuiz(code, questionToAdd);
		modelandview.setViewName(SUCCESS);
		return modelandview;
	}

	@RequestMapping("/modificationDeleteOperation")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public ModelAndView modificationDeleteQuestionPage() {
		ModelAndView modelandview=new ModelAndView();
		modelandview.setViewName("modifyDeletePage");
		return modelandview;
	}

	@PostMapping(value="deleteQuestionfromQuiz")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public ModelAndView modificationDeleteQuestion(Integer code,Integer questionToDelete) {
		ModelAndView modelandview=new ModelAndView();
		quizservice.deleteQuestionFromQuiz(code, questionToDelete);
		modelandview.setViewName(SUCCESS);
		return modelandview;
	}


}
