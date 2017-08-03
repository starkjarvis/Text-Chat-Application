package chat.java.service;

import java.sql.SQLException;

public interface InsertChatSingleDataService {
	
	public void insertChatSingleData(String user1, String user2, int chat_id, String date_time) throws SQLException;

}
