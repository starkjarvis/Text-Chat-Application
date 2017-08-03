package chat.java.dao;

import java.sql.SQLException;

public interface SignUpDao {
	
	public String signUp(String fullName, String email, String password, String dateOfBirth, String gender) throws SQLException;

}
