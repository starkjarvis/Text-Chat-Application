package chat.java.service.impl;

import java.sql.SQLException;

import chat.java.dao.LoginDao;
import chat.java.service.LoginService;

public class LoginServiceImpl implements LoginService {

	private LoginDao loginDao;
	public LoginDao getLoginDao() {
		return loginDao;
	}
	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}
	
	@Override
	public String executeLogin(String email, String password) throws SQLException {
		// TODO Auto-generated method stub
		return loginDao.executeLogin(email, password);
	}
	

}
