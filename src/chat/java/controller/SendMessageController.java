package chat.java.controller;

import java.sql.SQLException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import chat.java.service.impl.SendMessageServiceImpl;
import chat.java.viewBean.SendMessageBean;

@Controller
public class SendMessageController {
	
	@Autowired
	private SendMessageServiceImpl sendMessageService;
	
	@RequestMapping(value="/sendMessage",method=RequestMethod.POST)
	public ModelAndView sendMessage(HttpServletRequest request, HttpServletResponse response, SendMessageBean sendMessageBean, HttpSession session) throws SQLException
	{
		ModelAndView model = new ModelAndView("chatSingle");
		//inserting message along with all the details in chat table
		Date d=new Date();
		String date=d.toString();
		sendMessageService.sendMessage(session.getAttribute("loggedInUser").toString(), session.getAttribute("friendUsername").toString(), sendMessageBean.getMessage(), date, session);
		session.setAttribute("loggedInUser", session.getAttribute("loggedInUser"));
        session.setAttribute("friendUsername", session.getAttribute("friendUsername"));
        session.setAttribute("loggedInUser", session.getAttribute("loggedInUser"));
        session.setAttribute("friendUsername", session.getAttribute("friendUsername"));
		return model;
	}
	
	

}
