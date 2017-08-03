package chat.java.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import chat.java.dao.SendMessageChatRoomDao;

public class SendMessageChatRoomDaoImpl implements SendMessageChatRoomDao {

	@Override
	public void sendMessageChatRoom(String username, String date_time, String message) throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/chat","root","root");
		String query="insert into chatRoom values(?,?,?)";
		PreparedStatement ps=con.prepareStatement(query);
		ps.setString(1, username);
		ps.setString(2, message);
		ps.setString(3, date_time);
		ps.executeUpdate();

	}

}
