package chat.java.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import chat.java.dao.OnlineUsersDao;

public class OnlineUsersDaoImpl implements OnlineUsersDao {

	@Override
	public ResultSet onlineUsers() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/chat","root","root");
		String query="select * from login where status=?";
		PreparedStatement ps=con.prepareStatement(query);
		ps.setString(1, "online");
		ResultSet res=ps.executeQuery();
		return res;
	}

}
