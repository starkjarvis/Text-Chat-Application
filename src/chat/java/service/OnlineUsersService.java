package chat.java.service;

import java.sql.*;


public interface OnlineUsersService {
	
	public ResultSet onlineUsers() throws SQLException;

}
