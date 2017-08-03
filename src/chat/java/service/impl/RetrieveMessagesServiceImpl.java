package chat.java.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import chat.java.dao.RetrieveMessagesDao;
import chat.java.service.RetrieveMessagesService;

public class RetrieveMessagesServiceImpl implements RetrieveMessagesService {

	private RetrieveMessagesDao retrieveMessagesDao;
	public RetrieveMessagesDao getRetrieveMessagesDao() {
		return retrieveMessagesDao;
	}

	public void setRetrieveMessagesDao(RetrieveMessagesDao retrieveMessagesDao) {
		this.retrieveMessagesDao = retrieveMessagesDao;
	}
	
	@Override
	public ResultSet retrieveMessages(String from, String to) throws SQLException {
		// TODO Auto-generated method stub
		return retrieveMessagesDao.retrieveMessages(from, to);
	}

	

}
