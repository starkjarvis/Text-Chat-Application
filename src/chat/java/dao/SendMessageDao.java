package chat.java.dao;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

public interface SendMessageDao {
	
	public void sendMessage(String from, String to, String message, String data_time, HttpSession session) throws SQLException;

}
