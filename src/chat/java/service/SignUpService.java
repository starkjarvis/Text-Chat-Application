package chat.java.service;

import java.sql.SQLException;

public interface SignUpService {
	
	public String signUp(String fullName, String email, String password, String dateOfBirth, String gender) throws SQLException;

}
