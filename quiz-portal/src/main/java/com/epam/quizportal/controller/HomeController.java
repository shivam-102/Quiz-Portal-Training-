package com.epam.quizportal.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.epam.quizportal.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.epam.quizportal.service.UserService;

@Controller
public class HomeController {

    @Autowired
    UserService userservice;

    @RequestMapping("/")
    public String userPage() {
        return "user";
    }

    @RequestMapping("/userLogin")
    public ModelAndView userLoginPage() {
        ModelAndView modelandview = new ModelAndView();
        modelandview.setViewName("userLogin");
        return modelandview;
    }

    @PostMapping(value = "/userValidation")
    public ModelAndView userVerification(UserDTO userDTO, HttpServletRequest request) {
        ModelAndView modelandview = new ModelAndView();
        //boolean response = userservice.verifyUser(userDTO.getUsername(), userDTO.getPassword());
        HttpSession session = request.getSession();
        session.setAttribute("username",userDTO.getUsername());
        session.setAttribute("password", userDTO.getPassword());
//        if (response) {
//            modelandview.setViewName("homePage");
//        } else {
//            modelandview.setViewName("user");
//        }
        modelandview.setViewName("homePage");

        return modelandview;
    }

    @RequestMapping("/home")
    public String homePage(){
        return "homePage";
    }

    @RequestMapping("/signUp")
    public ModelAndView usersignUpPage() {
        ModelAndView modelandview = new ModelAndView();
        modelandview.setViewName("signUp");
        return modelandview;
    }

    @PostMapping("/register")
    public ModelAndView userRegistration(UserDTO user) {
        ModelAndView modelandview = new ModelAndView();
        boolean response = userservice.register(user);
        if (response) {
            modelandview.setViewName("userLogin");
        } else {
            modelandview.setViewName("signUp");
        }
        return modelandview;
    }
}
