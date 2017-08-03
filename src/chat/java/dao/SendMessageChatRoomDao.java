package chat.java.dao;

import java.sql.SQLException;

public interface SendMessageChatRoomDao {
	
	public void sendMessageChatRoom(String username, String date_time, String message) throws SQLException;

}
