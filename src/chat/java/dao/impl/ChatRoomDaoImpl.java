package chat.java.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import chat.java.dao.ChatRoomDao;

public class ChatRoomDaoImpl implements ChatRoomDao {

	@Override
	public ResultSet chatRoomMessages() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/chat","root","root");
		String query="select * from chatRoom";
		PreparedStatement ps=con.prepareStatement(query);
		ResultSet res=ps.executeQuery();
		
		return res;
	}

}
