package chat.java.dao;

import java.sql.SQLException;

public interface CheckOnlineDao {
	
	public String checkOnline(String email) throws SQLException;

}
