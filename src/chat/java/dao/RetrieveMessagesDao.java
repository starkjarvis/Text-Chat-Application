package chat.java.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RetrieveMessagesDao {
	public ResultSet retrieveMessages(String from, String to)throws SQLException;
}
