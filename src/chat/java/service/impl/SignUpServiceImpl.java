package chat.java.service.impl;

import java.sql.SQLException;

import chat.java.dao.SignUpDao;
import chat.java.service.SignUpService;

public class SignUpServiceImpl implements SignUpService {

	private SignUpDao signUpDao;
	
	public SignUpDao getSignUpDao() {
		return signUpDao;
	}

	public void setSignUpDao(SignUpDao signUpDao) {
		this.signUpDao = signUpDao;
	}

	@Override
	public String signUp(String fullName, String email, String password, String dateOfBirth, String gender)
			throws SQLException {
		return signUpDao.signUp(fullName, email, password, dateOfBirth, gender);

	}

}
