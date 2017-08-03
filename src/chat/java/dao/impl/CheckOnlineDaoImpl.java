package chat.java.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import chat.java.dao.CheckOnlineDao;

public class CheckOnlineDaoImpl implements CheckOnlineDao {

	@Override
	public String checkOnline(String email) throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String result="no";
		String status="";
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/chat","root","root");
		String query="select * from login where email=?";
		PreparedStatement ps=con.prepareStatement(query);
		ps.setString(1, email);
		ResultSet res=ps.executeQuery();
		while(res.next())
		{
			status=res.getString("status");
		}
		if(status.equalsIgnoreCase("online"))
			result="yes";
		
		return result;
	}

}
