package chat.java.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import chat.java.dao.OnlineUsersDao;
import chat.java.service.OnlineUsersService;

public class OnlineUsersServiceImpl implements OnlineUsersService {
	
	private OnlineUsersDao onlineUsersDao;
	
	public OnlineUsersDao getOnlineUsersDao() {
		return onlineUsersDao;
	}

	public void setOnlineUsersDao(OnlineUsersDao onlineUsersDao) {
		this.onlineUsersDao = onlineUsersDao;
	}

	@Override
	public ResultSet onlineUsers() throws SQLException {
		// TODO Auto-generated method stub
		return onlineUsersDao.onlineUsers();
	}

	

}
