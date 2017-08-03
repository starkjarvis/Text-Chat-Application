package chat.java.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ChatRoomDao {
	
	public ResultSet chatRoomMessages() throws SQLException;

}
