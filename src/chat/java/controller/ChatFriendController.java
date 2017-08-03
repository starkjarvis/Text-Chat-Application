package chat.java.controller;

import java.sql.*;

import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import chat.java.service.CheckOnlineService;
import chat.java.service.InsertChatSingleDataService;
import chat.java.service.RetrieveMessagesService;
import chat.java.viewBean.CheckOnlineBean;

@Controller
public class ChatFriendController {
	
	@Autowired
	private CheckOnlineService checkOnlineService;
	
	@Autowired
	private InsertChatSingleDataService insertChatSingleDataService;
	
	@Autowired
	private RetrieveMessagesService retrieveMessagesService;
	
	@RequestMapping(value="/chatFriend",method=RequestMethod.GET)
	public ModelAndView chatFriendGET(HttpServletRequest request, HttpServletResponse response, HttpSession session)
	{
		ModelAndView model = new ModelAndView("chatFriend");
		return model;
	}
	
	@RequestMapping(value="/chatFriend",method=RequestMethod.POST)
	public ModelAndView chatFriendPOST(HttpServletRequest request, HttpServletResponse response, HttpSession session, CheckOnlineBean checkOnlineBean) throws SQLException
	{
		ModelAndView model=null;
		
		//check whether friend is online or not.
		String result=checkOnlineService.checkOnline(checkOnlineBean.getEmail());
		if(result.equalsIgnoreCase("no"))
		{
			request.setAttribute("OnlineN", "Your friend is not online.");
			model=new ModelAndView("chatFriend");
		}
		else if(result.equalsIgnoreCase("yes")) {
			model=new ModelAndView("chatSingle");
			String user1=session.getAttribute("loggedInUser").toString();
			String user2=checkOnlineBean.getEmail();
			Random rand=new Random();
			int chat_id = rand.nextInt(2000) + 1;
			Date d=new Date();
			String date=d.toString();
			
			/*insertChatSingleDataService.insertChatSingleData(user1, user2, chat_id, date);*/
			session.setAttribute("chat_id", chat_id);
			session.setAttribute("friendUsername", user2);
			
			request.setAttribute("chat_id", chat_id);
			request.setAttribute("friendUsername", user2);
			//ResultSet res=retrieveMessagesService.retrieveMessages(session.getAttribute("loggedInUser").toString(), session.getAttribute("friendUsername").toString());
			
			//request.setAttribute("messagesRes", res);
			
		}
		return model;
	}

}
