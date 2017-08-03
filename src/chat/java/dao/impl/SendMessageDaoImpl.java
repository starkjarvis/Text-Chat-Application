package chat.java.dao.impl;

import java.sql.*;

import javax.servlet.http.HttpSession;

import chat.java.dao.SendMessageDao;

public class SendMessageDaoImpl implements SendMessageDao {

	@Override
	public void sendMessage(String from, String to, String message, String data_time, HttpSession session) throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/chat","root","root");
		String query="insert into chat1 values(?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(query);
		ps.setString(1, session.getAttribute("loggedInUser").toString());
		ps.setString(2, session.getAttribute("friendUsername").toString());
		ps.setInt(3, Integer.parseInt(session.getAttribute("chat_id").toString()));
		ps.setString(4, message);
		ps.setString(5, data_time);
		ps.executeUpdate();
		
	}

}
