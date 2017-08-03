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

import chat.java.service.ChatRoomService;


@Controller
public class ChatRoomController {
	
	@Autowired
	private ChatRoomService chatRoomService;
	
	@RequestMapping(value="/chatRoom",method=RequestMethod.GET)
	public ModelAndView displayChatRoom(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws SQLException
	{
		ModelAndView model = new ModelAndView("chatRoom");
		return model;
	}
	
	@RequestMapping(value="/getChatRoomMessage",method=RequestMethod.GET)
	public ModelAndView displayChatRoomMessage(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws SQLException
	{
		ModelAndView model = new ModelAndView("getTable");
		ResultSet res=chatRoomService.chatRoomMessages();
		session.setAttribute("chatRoom", res);
		return model;
	}

}
