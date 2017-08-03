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

import chat.java.service.SendMessageChatRoomService;
import chat.java.viewBean.SendMessageBean;

@Controller
public class SendMessage2Controller {
	
	@Autowired
	private SendMessageChatRoomService sendMessageChatRoom;
	
	@RequestMapping(value="/sendMessage1",method=RequestMethod.POST)
	public ModelAndView sendMessage2(HttpServletRequest request, HttpServletResponse response, SendMessageBean sendMessageBean, HttpSession session) throws SQLException
	{
		ModelAndView model = new ModelAndView("chatRoom");
		//inserting message along with all the details in chat table
		Date d=new Date();
		String date=d.toString();
		sendMessageChatRoom.sendMessageChatRoom(session.getAttribute("loggedInUser").toString(), date, sendMessageBean.getMessage());
		session.setAttribute("loggedInUser", session.getAttribute("loggedInUser"));
        session.setAttribute("friendUsername", session.getAttribute("friendUsername"));
        session.setAttribute("loggedInUser", session.getAttribute("loggedInUser"));
        session.setAttribute("friendUsername", session.getAttribute("friendUsername"));
		return model;
	}

}
