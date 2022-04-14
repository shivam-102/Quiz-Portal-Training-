//package com.epam.quizportal.controller;
//
//import java.util.List;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.epam.quizportal.entity.Questions;
//import com.epam.quizportal.service.QuizService;
//
//@Controller
//public class QuizController {
//
//	@Autowired
//	QuizService quizservice;
//
//
//
//	@RequestMapping("/insertCode")
//	public ModelAndView viewQuiz(){
//		ModelAndView modelandview=new ModelAndView();
//		modelandview.setViewName("codeInsertPage");
//		return modelandview;
//	}
//
//	@PostMapping(value="questionsInTheQuiz")
//	public ModelAndView viewQuizInsertCode(int code) {
//		ModelAndView modelandview=new ModelAndView();
//		System.out.println(code);
//		modelandview.addObject("quiz",quizservice.viewQuizQuestions(code));
//		modelandview.setViewName("questionsInTheQuiz");
//		return modelandview;
//	}
//
//
//	@RequestMapping("/createQuiz")
//	public ModelAndView createQuizPage() {
//		ModelAndView modelandview=new ModelAndView();
//		modelandview.setViewName("createQuizPage");
//		return modelandview;
//	}
//
//	@PostMapping(value="createnewquiz")
//	public ModelAndView createQuiz(String questionsids) {
//		ModelAndView modelandview= new ModelAndView();
//		List<Integer> questionList = Stream.of(questionsids.split(","))
//				  .map(String::trim)
//				  .map(Integer::parseInt)
//				  .collect(Collectors.toList());
//		quizservice.createQuizService(questionList);
//		modelandview.setViewName("success");
//		return modelandview;
//	}
//
//	@RequestMapping("/modificationAddOperation")
//	public ModelAndView modificationAddQuestionPage() {
//		ModelAndView modelandview=new ModelAndView();
//		modelandview.setViewName("modifyAddPage");
//		return modelandview;
//	}
//
//	@PostMapping(value="addQuestionToQuiz")
//	public ModelAndView modificationAddQuestion(Integer code,Integer questionToAdd) {
//		ModelAndView modelandview=new ModelAndView();
//		quizservice.addQuestion(code, questionToAdd);
//		modelandview.setViewName("success");
//		return modelandview;
//	}
//
//	@RequestMapping("/modificationDeleteOperation")
//	public ModelAndView modificationDeleteQuestionPage() {
//		ModelAndView modelandview=new ModelAndView();
//		modelandview.setViewName("modifyDeletePage");
//		return modelandview;
//	}
//
//	@PostMapping(value="deleteQuestionfromQuiz")
//	public ModelAndView modificationDeleteQuestion(Integer code,Integer questionToDelete) {
//		ModelAndView modelandview=new ModelAndView();
//		quizservice.deleteQuestion(code, questionToDelete);
//		modelandview.setViewName("success");
//		return modelandview;
//	}
//
//
//}
