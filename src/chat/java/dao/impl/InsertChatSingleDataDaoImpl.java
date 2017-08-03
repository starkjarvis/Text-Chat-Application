package chat.java.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import chat.java.dao.InsertChatSingleDataDao;

public class InsertChatSingleDataDaoImpl implements InsertChatSingleDataDao {

	@Override
	public void insertChatSingleData(String user1, String user2, int chat_id, String date_time) throws SQLException {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/chat","root","root");
		
		String query="insert into chat(from, to, chat_id, date_time) values(?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(query);
		ps.setString(1, user1);
		ps.setString(2, user2);
		ps.setInt(3, chat_id);
		ps.setString(4, date_time);
		ps.executeUpdate();
		
	}

}
