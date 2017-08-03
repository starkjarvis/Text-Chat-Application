package chat.java.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import chat.java.dao.ChatRoomDao;
import chat.java.service.ChatRoomService;

public class ChatRoomServiceImpl implements ChatRoomService {
	
	private ChatRoomDao chatRoomDao;
	public ChatRoomDao getChatRoomDao() {
		return chatRoomDao;
	}

	public void setChatRoomDao(ChatRoomDao chatRoomDao) {
		this.chatRoomDao = chatRoomDao;
	}


	@Override
	public ResultSet chatRoomMessages() throws SQLException {
		// TODO Auto-generated method stub
		return chatRoomDao.chatRoomMessages();
	}

	
}
