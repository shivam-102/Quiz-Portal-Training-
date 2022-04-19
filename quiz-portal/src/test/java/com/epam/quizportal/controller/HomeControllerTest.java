package com.epam.quizportal.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import com.epam.quizportal.dto.UserDTO;
import com.epam.quizportal.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;




@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers =HomeController.class)
class HomeControllerTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	UserService userService;

	@Test
	void test() {
		HomeController homecontroller=new HomeController();
		ModelAndView modelandview=homecontroller.userLoginPage();
		assertEquals("userLogin",modelandview.getViewName());

	}

	@Test
	void testUserPage() throws Exception {
		HomeController homecontroller=new HomeController();
		assertEquals("user",homecontroller.userPage());
		mockMvc.perform(get("/userLogin")).andExpect(status().isOk()).andExpect(view().name("userLogin"));
	}


	@Test
	void userPage() {
		HomeController homecontroller=new HomeController();
		ModelAndView modelandview=homecontroller.userLoginPage();
		assertEquals("userLogin",modelandview.getViewName());


	}

	@Test
	void userVerification() throws Exception {
		MockHttpSession session = Mockito.mock(MockHttpSession.class);
		HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
		when(request.getSession()).thenReturn(session);
		when(session.getAttribute("username")).thenReturn("shivam");
		when(session.getAttribute("password")).thenReturn("123");

		when(userService.verifyUser("shivam","123")).thenReturn(true);
		mockMvc.perform(post("/userValidation")).andExpect(status().isOk()).andExpect(view().name("user"));
	}

	@Test
	void usersignUpPage() throws Exception {

		HomeController homecontroller=new HomeController();
		ModelAndView modelandview=homecontroller.usersignUpPage();
		assertEquals("signUp",modelandview.getViewName());
		mockMvc.perform(get("/signUp")).andExpect(status().isOk()).andExpect(view().name("signUp"));
	}


	@Test
	void userRegistration() throws Exception {
		UserDTO user = new UserDTO();
		user.setUsername("user");
		user.setPassword("pass");
		HomeController homecontroller = new HomeController();
		when(userService.register(user)).thenReturn(true);
		mockMvc.perform(post("/register")).andExpect(status().isOk()).andExpect(view().name("signUp"));

	}
}
