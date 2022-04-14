package com.epam.quizportal.controller;

import com.epam.quizportal.entity.Options;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.epam.quizportal.dto.QuestionDTO;
import com.epam.quizportal.service.QuestionService;

import java.util.List;

@Controller
public class QuestionController {
	@Autowired
	QuestionService questionservice;
	
	
	@RequestMapping("/viewAvailableQuestions")
	public ModelAndView viewQuestion(){
		ModelAndView modelandview=new ModelAndView();
		//modelandview.addObject("questions",questionservice.viewQuestions());
		modelandview.setViewName("viewQuestions");
		return modelandview;
	}
	
	@RequestMapping("/addingQuestion")
	public ModelAndView openPage() {
		ModelAndView modelandview=new ModelAndView();
		modelandview.setViewName("createQuestion");
		return modelandview;
	}
	
	@PostMapping(value="addQuestion")
	public ModelAndView addingQuestion(QuestionDTO questiondto) {
		ModelAndView modelandview=new ModelAndView();
		questionservice.insertQuestion(questiondto);
		modelandview.setViewName("success");
		return modelandview;
		
	}


	@RequestMapping("/deleteQuestion")
	public ModelAndView deleteQuestionPage() {
		ModelAndView modelandview=new ModelAndView();
		modelandview.setViewName("deleteQuestion");
		return modelandview;
		
	}
	
	@PostMapping(value="removeQuestion")
	public ModelAndView deletingQuestion(Integer questionNumber) {
		ModelAndView modelandview=new ModelAndView();
		questionservice.deleteQuestion(questionNumber);
		modelandview.setViewName("success");
		return modelandview;
	}

	
	@RequestMapping("/modifyQuestion")
	public ModelAndView modifyQuestionPage() {
		ModelAndView modelandview=new ModelAndView();
		modelandview.setViewName("modifyQuestionPage");
		return modelandview;
	}
	
	@PostMapping(value="modifyquestion")
	public ModelAndView modifyQuestion(Integer questionNumber,String newQuestion) {
		ModelAndView modelandview=new ModelAndView();
		Boolean response=questionservice.modifyQuestion(questionNumber,newQuestion);
		if(response==true) {
			modelandview.setViewName("success");
			
		}
		else {
			modelandview.setViewName("modifyQuestionPage");
		}
		return modelandview;
	}

	
	@RequestMapping("/modifyDifficulty")
	public ModelAndView modifyDifficultyPage() {
		ModelAndView modelandview=new ModelAndView();
		modelandview.setViewName("modifyDifficultyPage");
		return modelandview;
	}
	
	@PostMapping(value="modifydifficulty")
	public ModelAndView modifyDifficulty(Integer questionNumber,String newDifficulty) {
		ModelAndView modelandview=new ModelAndView();
		Boolean response=questionservice.modifyDifficulty(questionNumber,newDifficulty);
		if(response==true) {
			modelandview.setViewName("success");
			
		}
		else {
			modelandview.setViewName("modifyDifficultyPage");
		}
		return modelandview;
	}


	@RequestMapping("/modifyMarks")
	public ModelAndView modifyMarksPage() {
		ModelAndView modelandview=new ModelAndView();
		modelandview.setViewName("modifyMarksPage");
		return modelandview;
	}
	
	@PostMapping(value="modifymarks")
	public ModelAndView modifyMarks(Integer questionNumber,Integer newMarks) {
		ModelAndView modelandview=new ModelAndView();
		Boolean response=questionservice.modifyMarks(questionNumber,newMarks);
		if(response==true) {
			modelandview.setViewName("success");
			
		}
		else {
			modelandview.setViewName("modifyMarksPage");
		}
		return modelandview;
	}

	
	@RequestMapping("/modifyOptions")
	public ModelAndView modifyOptionsPage() {
		ModelAndView modelandview=new ModelAndView();
		modelandview.setViewName("modifyOptionsPage");
		return modelandview;
	}
	
	@PostMapping(value="modifyoptions")
	public ModelAndView modifyOptions(List<Options> newOptions, Integer questionNumber) {
		System.out.println(newOptions);
		ModelAndView modelandview=new ModelAndView();
		System.out.println(newOptions);
		Boolean response=questionservice.modifyOptions(questionNumber,newOptions);
		if(response==true) {
			modelandview.setViewName("success");
			
		}
		else {
			modelandview.setViewName("modifyOptionsPage");
		}
		return modelandview;
		
	}


}
