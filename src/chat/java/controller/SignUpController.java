package chat.java.controller;


import java.sql.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import chat.java.service.SignUpService;
import chat.java.viewBean.LoginBean;

@Controller
public class SignUpController {
	
	@Autowired
	private SignUpService signUpService;
	
	@RequestMapping(value="/signup",method=RequestMethod.GET)
	public ModelAndView displaySignUp(HttpServletRequest request, HttpServletResponse response, LoginBean loginBean, HttpSession session)
	{
		ModelAndView model = new ModelAndView("SignUp");
		
		
		return model;
	}

	@RequestMapping(value="/signup",method=RequestMethod.POST)
	public ModelAndView executeSignUp(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws SQLException
	{
		
		ModelAndView model=new ModelAndView("SignUp");
		
		String fullName=request.getParameter("fullName");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String dateOfBirth=request.getParameter("dateOfBirth");
		String gender=request.getParameter("gender");
		String result=signUpService.signUp(fullName, email, password, dateOfBirth, gender);
		
		if(result.equalsIgnoreCase("yes"))
			request.setAttribute("registrationY", "Registration Done. Login to continue.");
		else
			request.setAttribute("registrationN", "Email already exists! Please choose another one and try again.");
		return model;
	}
}
