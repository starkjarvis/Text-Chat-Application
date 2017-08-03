package chat.java.dao;

import java.sql.SQLException;

public interface InsertChatSingleDataDao {
	
	public void insertChatSingleData(String user1, String user2, int chat_id, String date_time) throws SQLException;

}
