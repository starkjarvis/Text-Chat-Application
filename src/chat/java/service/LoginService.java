package chat.java.service;

import java.sql.SQLException;

public interface LoginService {
	
	public String executeLogin(String email, String password) throws SQLException;

}
