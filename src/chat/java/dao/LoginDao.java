package chat.java.dao;

import java.sql.SQLException;

public interface LoginDao {
	
	public String executeLogin(String email, String password) throws SQLException;

}
