package chat.java.service.impl;

import java.sql.SQLException;

import chat.java.dao.CheckOnlineDao;
import chat.java.service.CheckOnlineService;

public class CheckOnlineServiceImpl implements CheckOnlineService {

	private CheckOnlineDao checkOnlineDao;
	public CheckOnlineDao getCheckOnlineDao() {
		return checkOnlineDao;
	}
	public void setCheckOnlineDao(CheckOnlineDao checkOnlineDao) {
		this.checkOnlineDao = checkOnlineDao;
	}
	
	@Override
	public String checkOnline(String email) throws SQLException {
		// TODO Auto-generated method stub
		return checkOnlineDao.checkOnline(email);
	}
	

}
