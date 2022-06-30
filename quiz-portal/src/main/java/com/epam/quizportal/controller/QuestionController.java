package com.epam.quizportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.epam.quizportal.dto.QuestionDTO;
import com.epam.quizportal.service.QuestionService;

@Controller
public class QuestionController {
	@Autowired
	QuestionService questionservice;

	static final String SUCCESS="success";

	@RequestMapping("/viewAvailableQuestions")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public ModelAndView viewQuestion(){
		ModelAndView modelandview=new ModelAndView();
		modelandview.addObject("questions",questionservice.viewQuestions());
		modelandview.setViewName("viewQuestions");
		return modelandview;
	}

	@RequestMapping("/addingQuestion")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public ModelAndView openPage() {
		ModelAndView modelandview=new ModelAndView();
		modelandview.setViewName("createQuestion");
		return modelandview;
	}
	
	@PostMapping(value="addQuestion")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public ModelAndView addingQuestion(QuestionDTO questiondto) {
		ModelAndView modelandview=new ModelAndView();
		questionservice.insertQuestion(questiondto);
		modelandview.setViewName(SUCCESS);
		return modelandview;
		
	}

	@RequestMapping("/deleteQuestion")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public ModelAndView deleteQuestionPage() {
		ModelAndView modelandview=new ModelAndView();
		modelandview.setViewName("deleteQuestion");
		return modelandview;
		
	}
	
	@PostMapping(value="removeQuestion")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public ModelAndView deletingQuestion(Integer questionNumber) {
		ModelAndView modelandview=new ModelAndView();
		questionservice.deleteQuestion(questionNumber);
		modelandview.setViewName(SUCCESS);
		return modelandview;
	}

	@RequestMapping("/getQuestion")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public ModelAndView getQuestionPage(){
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("getQuestionPage");
		return modelAndView;
	}

	@PostMapping(value="/fetchQuestionById")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public ModelAndView getQuestion(Integer questionNumber){
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("questionById",questionservice.viewQuestionById(questionNumber));
		modelAndView.setViewName("updateQuestionPage");
		return modelAndView;

	}

	@PostMapping("/updateQuestion")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public ModelAndView updateQuestionPage(QuestionDTO questionDTO){
		ModelAndView modelAndView=new ModelAndView();
		questionservice.updateQuestion(questionDTO);
		modelAndView.setViewName(SUCCESS);
		return modelAndView;
	}


}
