package chat.java.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import chat.java.service.LoginService;
import chat.java.viewBean.LoginBean;


@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public ModelAndView displayLogin(HttpServletRequest request, HttpServletResponse response, LoginBean loginBean, HttpSession session)
	{
		ModelAndView model = new ModelAndView("login");
		model.addObject("loginBean", loginBean);
		return model;
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView executeLogin(HttpServletRequest request, HttpServletResponse response, LoginBean loginBean, HttpSession session) throws SQLException
	{
		ModelAndView model=null;
		String result=loginService.executeLogin(loginBean.getUsername(), loginBean.getPassword());
		if(result.equalsIgnoreCase("yes")) {
			model=new ModelAndView("user");
			request.setAttribute("loggedInUser", loginBean.getUsername());
			session.setAttribute("loggedInUser", loginBean.getUsername());
		}
		else {
			model=new ModelAndView("login");
			request.setAttribute("loginN", "Wrong credentials! Please try again or register to continue.");
		}
		return model;
	}

}
