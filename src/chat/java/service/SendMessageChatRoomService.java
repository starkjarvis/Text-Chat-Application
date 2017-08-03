package chat.java.service;

import java.sql.SQLException;

public interface SendMessageChatRoomService {
	
	public void sendMessageChatRoom(String username, String date_time, String message) throws SQLException;

}
