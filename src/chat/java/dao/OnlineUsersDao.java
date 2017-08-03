package chat.java.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface OnlineUsersDao {
	
	public ResultSet onlineUsers() throws SQLException;

}
