package chat.java.service;

import java.sql.*;

public interface RetrieveMessagesService {
	
	public ResultSet retrieveMessages(String from, String to)throws SQLException;

}
