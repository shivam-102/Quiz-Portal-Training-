package com.epam.quizportal.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.epam.quizportal.dto.UserDTO;
import com.epam.quizportal.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
    public ModelAndView userVerification( HttpServletRequest request) {
        ModelAndView modelandview = new ModelAndView();
        HttpSession session = request.getSession();
        String username;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }
        session.setAttribute("username",username);
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
