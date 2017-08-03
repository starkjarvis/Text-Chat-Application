package chat.java.service.impl;

import java.sql.SQLException;

import chat.java.dao.SendMessageChatRoomDao;

import chat.java.service.SendMessageChatRoomService;

public class SendMessageChatRoomServiceImpl implements SendMessageChatRoomService {
	
	private SendMessageChatRoomDao sendMessageChatRoomDao;

	public SendMessageChatRoomDao getSendMessageChatRoomDao() {
		return sendMessageChatRoomDao;
	}

	public void setSendMessageChatRoomDao(SendMessageChatRoomDao sendMessageChatRoomDao) {
		this.sendMessageChatRoomDao = sendMessageChatRoomDao;
	}

	@Override
	public void sendMessageChatRoom(String username, String date_time, String message) throws SQLException {
		sendMessageChatRoomDao.sendMessageChatRoom(username, date_time, message);

	}

}
