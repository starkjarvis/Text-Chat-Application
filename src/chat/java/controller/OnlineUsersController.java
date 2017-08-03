package chat.java.controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import chat.java.service.OnlineUsersService;


@Controller
public class OnlineUsersController {
	
	@Autowired
	private OnlineUsersService onlineUserService;
	
	@RequestMapping(value="/seeOnlineUsers",method=RequestMethod.GET)
	public ModelAndView displayLogin(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws SQLException
	{
		ModelAndView model = new ModelAndView("seeOnlineUsers");
		ResultSet res=onlineUserService.onlineUsers();
		request.setAttribute("onlineUsers", res);
		return model;
	}

}
