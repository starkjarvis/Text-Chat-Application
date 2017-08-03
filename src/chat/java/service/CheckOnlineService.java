package chat.java.service;

import java.sql.SQLException;

public interface CheckOnlineService {
	
	public String checkOnline(String email) throws SQLException;

}
