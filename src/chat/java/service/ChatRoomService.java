package chat.java.service;

import java.sql.*;

public interface ChatRoomService {
	
	public ResultSet chatRoomMessages() throws SQLException;

}
