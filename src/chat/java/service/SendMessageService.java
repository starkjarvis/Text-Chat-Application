package chat.java.service;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

public interface SendMessageService {

	public void sendMessage(String from, String to, String message, String data_time, HttpSession session) throws SQLException;
}
