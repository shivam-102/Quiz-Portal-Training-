package com.epam.quizportal.controller;

import com.epam.quizportal.dto.OptionsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.epam.quizportal.dto.QuestionDTO;
import com.epam.quizportal.service.QuestionService;

import java.util.ArrayList;

@Controller
public class QuestionController {
	@Autowired
	QuestionService questionservice;

	static final String SUCCESS="success";

	@RequestMapping("/viewAvailableQuestions")
	public ModelAndView viewQuestion(){
		ModelAndView modelandview=new ModelAndView();
		modelandview.addObject("questions",questionservice.viewQuestions());
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
		modelandview.setViewName(SUCCESS);
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
		modelandview.setViewName(SUCCESS);
		return modelandview;
	}

	@RequestMapping("/questionModification")
	public ModelAndView questionModificationPage(){
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("questionModificationPage");
		return modelAndView;
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
		boolean response=questionservice.modifyQuestion(questionNumber,newQuestion);
		if(response) {
			modelandview.setViewName(SUCCESS);
			
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
		boolean response=questionservice.modifyDifficulty(questionNumber,newDifficulty);
		if(response) {
			modelandview.setViewName(SUCCESS);
			
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
		boolean response=questionservice.modifyMarks(questionNumber,newMarks);
		if(response) {
			modelandview.setViewName(SUCCESS);
			
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
	public ModelAndView modifyOptions( ArrayList<OptionsDTO> option, @RequestParam(name="questionNumber") Integer questionNumber) {
		ModelAndView modelandview=new ModelAndView();
		boolean response=questionservice.modifyOptions(questionNumber,option);
		if(response) {
			modelandview.setViewName(SUCCESS);
			
		}
		else {
			modelandview.setViewName("modifyOptionsPage");
		}
		return modelandview;
		
	}


}
