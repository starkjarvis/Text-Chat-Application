package chat.java.service.impl;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import chat.java.dao.SendMessageDao;

public class SendMessageServiceImpl implements chat.java.service.SendMessageService {

	private SendMessageDao sendMessageDao;
	public SendMessageDao getSendMessageDao() {
		return sendMessageDao;
	}
	public void setSendMessageDao(SendMessageDao sendMessageDao) {
		this.sendMessageDao = sendMessageDao;
	}
	
	@Override
	public void sendMessage(String from, String to, String message, String data_time, HttpSession session) throws SQLException {
		sendMessageDao.sendMessage(from, to, message, data_time, session);
	}
	

}
