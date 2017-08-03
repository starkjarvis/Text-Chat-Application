package chat.java.service.impl;

import java.sql.SQLException;

import chat.java.dao.InsertChatSingleDataDao;
import chat.java.service.InsertChatSingleDataService;

public class InsertChatSingleDataServiceImpl implements InsertChatSingleDataService {

	private InsertChatSingleDataDao insertChatSingleDataDao;
	public InsertChatSingleDataDao getInsertChatSingleDataDao() {
		return insertChatSingleDataDao;
	}
	public void setInsertChatSingleDataDao(InsertChatSingleDataDao insertChatSingleDataDao) {
		this.insertChatSingleDataDao = insertChatSingleDataDao;
	}
	@Override
	public void insertChatSingleData(String user1, String user2, int chat_id, String date_time) throws SQLException {
		insertChatSingleDataDao.insertChatSingleData(user1, user2, chat_id, date_time);

	}
	

}
